package xyf.frpc.rpc;

import java.util.Arrays;

public class MethodInvocation implements Invocation {

	private String interfaceFullName;
	private String methodName;
	
	private Class<?> [] parameterTypes;
	
	private Object [] arguments;
	
	

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

	public void setArguments(Object [] arguments) {
		this.arguments = arguments;
		System.out.println("---MethodInvocation " + Arrays.toString(this.arguments));
	}

	public void setParameterTypes(Class<?> [] parameterTypes) {
		this.parameterTypes = parameterTypes;
		System.out.println("---MethodInvocation " + Arrays.toString(this.parameterTypes));
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
		res.append("-----MethodInvocation(\n");
		res.append(this.interfaceFullName + "\n");
		res.append(this.methodName +"\n");
		res.append(Arrays.toString(this.parameterTypes) + "\n");
		res.append(Arrays.toString(this.arguments) + "\n)");
		return res.toString();
	}

}
