package xyf.frpc.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import xyf.frpc.rpc.Invocation;
import xyf.frpc.rpc.MethodInvocation;

public class JDKProxyFactory implements ProxyFactory {

	public Object getProxy(Class interfaceClass, Object target,
			boolean isProvider) {
		return Proxy.newProxyInstance(interfaceClass.getClassLoader(),
				new Class[] { interfaceClass },
				isProvider ? new JDKProviderInvocationHandler(target)
						: new JDKReferenceInvocationHandler(target,
								interfaceClass));
	}

}

class JDKProviderInvocationHandler implements InvocationHandler {

	public JDKProviderInvocationHandler(Object target) {
		this.proxied = target;
	}

	private Object proxied;

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		return method.invoke(proxied, args);
	}

}

class JDKReferenceInvocationHandler implements InvocationHandler {

	private Class interfaceClass;

	private List<String> methodNames = new ArrayList<String>();;

	private Object trivialObjectForDefaultMethod = new Object();

	private Method invokerMethod;

	// FrpcInvoker
	private Object proxied;

	public JDKReferenceInvocationHandler(Object target, Class interfaceClass) {
		this.proxied = target;
		this.interfaceClass = interfaceClass;
		Method[] methods = interfaceClass.getDeclaredMethods();
		if (methods != null && methods.length > 0) {
			for (Method method : methods) {
				methodNames.add(method.getName());
			}
		}

		try {
			invokerMethod = proxied.getClass().getDeclaredMethod("invoker",
					Invocation.class);
			invokerMethod.setAccessible(true);
		} catch (Exception e) {
			System.out
					.println("frpc: JDKReferenceInvocationHandler get invokerMethod error");
		}
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (!methodNames.contains(method.getName())) {
			return method.invoke(trivialObjectForDefaultMethod, args);
		}
		Invocation invocation = new MethodInvocation();
		invocation.setArguments(args);
		invocation.setParameterTypes(method.getParameterTypes());
		invocation.setMethodName(method.getName());
		invocation.setInterfaceFullName(interfaceClass.getName());

		return invokerMethod.invoke(proxied, args);
	}

}
