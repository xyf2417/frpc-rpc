package xyf.frpc.rpc;

import java.lang.reflect.Method;

public class StubInvoker <T> extends AbstractInvoker<T> {

	private Invoker invoker;
	
	public Invoker getInvoker() {
		return invoker;
	}

	public void setInvoker(Invoker invoker) {
		this.invoker = invoker;
	}

	private Class stubClass;
	
	public StubInvoker(Invoker invoker,Class stubClass) {
		this.invoker = invoker;
		this.setStubClass(stubClass);
	}

	public Result invoke(Invocation invocation) throws RpcException {
		return null;
	}

	public Class getStubClass() {
		return stubClass;
	}

	public void setStubClass(Class stubClass) {
		this.stubClass = stubClass;
	}
}
