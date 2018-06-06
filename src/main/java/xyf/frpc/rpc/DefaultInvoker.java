package xyf.frpc.rpc;

import java.lang.reflect.Method;

public class DefaultInvoker<T> extends AbstractInvoker<T> {

	public Result invoke(Invocation invocation) {
		Object proxy = this.getProxy();
		
		String methodName = invocation.getMethodName();
		Class[] parameterTypes = invocation.getParameterTypes();
		Object [] args = invocation.getArguments();
		Method method = null;
		try {
			method = proxy.getClass().getMethod(methodName, parameterTypes);
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
