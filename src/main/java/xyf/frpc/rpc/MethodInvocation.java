package xyf.frpc.rpc;

public class MethodInvocation implements Invocation {

	private String methodName;
	
	private Class<?> [] parameterTypes;
	
	private Object [] arguments;
	
	

	public String getMethodName() {
		return methodName;
	}

	public Class<?>[] getParameterTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] getArguments() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setArguments(Object [] arguments) {
		this.arguments = arguments;
	}

	public void setParameterTypes(Class<?> [] parameterTypes) {
		this.parameterTypes = parameterTypes;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

}
