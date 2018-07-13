package xyf.frpc.rpc;

import java.util.Arrays;

public class MethodInvocation implements Invocation {

	private long invokeId;
	private String interfaceFullName;
	private String methodName;

	private Class<?>[] parameterTypes;

	private Object[] arguments;

	public String getMethodName() {
		return methodName;
	}

	public Class<?>[] getParameterTypes() {
		// TODO Auto-generated method stub
		return parameterTypes;
	}

	public Object[] getArguments() {
		// TODO Auto-generated method stub
		return arguments;
	}

	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}

	public void setParameterTypes(Class<?>[] parameterTypes) {
		this.parameterTypes = parameterTypes;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getInterfaceFullName() {
		return interfaceFullName;
	}

	public void setInterfaceFullName(String interfaceFullName) {
		this.interfaceFullName = interfaceFullName;
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("MethodInvocation(invokeId=");
		res.append(invokeId + ",");
		res.append(this.interfaceFullName + ".");
		res.append(this.methodName + "(");
		res.append(Arrays.toString(this.parameterTypes) + "))");
		return res.toString();
	}

	public void setInvokeId(long id) {
		this.invokeId = id;
	}

	public long getInvokerId() {
		// TODO Auto-generated method stub
		return this.invokeId;
	}

}
