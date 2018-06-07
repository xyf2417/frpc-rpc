package xyf.frpc.rpc;

import java.lang.reflect.Method;
import java.util.Arrays;

public class DefaultInvoker<T> extends AbstractInvoker<T> {

	public Result invoke(Invocation invocation) {
		Object proxy = this.getProxy();
		
		String methodName = invocation.getMethodName();
		Class[] parameterTypes = invocation.getParameterTypes();
		Object [] args = invocation.getArguments();
		Method method = null;
		Class clazz = null;
		try {
			try {
				clazz = Class.forName(invocation.getInterfaceFullName());
			} catch (ClassNotFoundException e) {
				System.out.println("DefaultInvoker invoke forname error");
			}
			System.out.println("-------DefaultInvoker " + invocation.getInterfaceFullName());
			System.out.println("-------DefaultInvoker " + Arrays.toString(parameterTypes));
			System.out.println("-------DefaultInvoker " + Arrays.toString(args));
			method = clazz.getMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException e) {
			
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		Result result = new RpcResult();
		if(method == null) {
			result.setStatus(ResultStatus.ERROR);
			
		}
		else{
			try {
				Object value = method.invoke(proxy, args);
				result.setStatus(ResultStatus.NORMAL);
				result.setValue(value);
			} catch (Throwable e) {
				result.setStatus(ResultStatus.ERROR);
			}
		}
		
		return result;
	}

}
