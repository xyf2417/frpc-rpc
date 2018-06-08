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
		
		Result result = new RpcResult();
		try {
			try {
				clazz = Class.forName(invocation.getInterfaceFullName());
			} catch (ClassNotFoundException e) {
				result.setStatus(ResultStatus.NO_SUCH_INTERFACE);
			}
			method = clazz.getMethod(methodName, parameterTypes);
			
		} catch (NoSuchMethodException e) {
			result.setStatus(ResultStatus.NO_SUCH_METHOD);
		} catch (SecurityException e) {
			result.setStatus(ResultStatus.ERROR);
		}

		try {
			Object value = method.invoke(proxy, args);
			result.setStatus(ResultStatus.NORMAL);
			result.setValue(value);
		} catch (Throwable e) {
			result.setStatus(ResultStatus.ERROR);
		}
		
		return result;
	}

}
