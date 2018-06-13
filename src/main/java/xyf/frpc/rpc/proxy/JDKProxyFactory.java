package xyf.frpc.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class JDKProxyFactory implements ProxyFactory{

	public Object getProxy(Class interfaceClass, Object target) {
		return Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new JDKInvocationHandler(target));
	}
	

}

class JDKInvocationHandler implements InvocationHandler {
	
	public JDKInvocationHandler(Object target) {
		this.proxied = target;
	}
	private Object proxied;
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		return method.invoke(proxied, args);
	}
	
}
