package xyf.frpc.rpc;

import java.lang.reflect.Method;

public class StubInvoker <T> extends AbstractInvoker<T> {

	private Invoker invoker;
	
	public StubInvoker(Invoker invoker) {
		this.invoker = invoker;
	}

	public Result invoke(Invocation invocation) throws RpcException {
		try{
			return invoker.invoke(invocation);
		} catch(Exception e) {
			RpcResult result = new RpcResult();
			try{
				Class clazz = this.getInterface();
				Method method= clazz.getDeclaredMethod(invocation.getMethodName(), invocation.getParameterTypes());
				Object returnValue = method.invoke(this.getProxy(), invocation.getArguments());
				result.setStatus(ResultStatus.MOCK);
				result.setValue(returnValue);
			} catch(Exception em) {
				result.setStatus(ResultStatus.MOCK_ERROR);
				result.setValue(em.getMessage());
			}
			return result;
		}
	}
}
