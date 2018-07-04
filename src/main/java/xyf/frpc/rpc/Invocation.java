package xyf.frpc.rpc;

public interface Invocation {

	public String getMethodName();

	/**
	 * get parameter types.
	 * 
	 * @return parameter types.
	 * @serial
	 */
	Class<?>[] getParameterTypes();

	/**
	 * get arguments.
	 * 
	 * @return arguments.
	 * @serial
	 */
	Object[] getArguments();

	void setParameterTypes(Class<?>[] parameterTypes);

	void setArguments(Object[] args);

	void setMethodName(String methodName);

	public String getInterfaceFullName();

	public void setInterfaceFullName(String interfaceFullName);
	
	public void setInvokeId(long id);
	
	public long getInvokerId();
}
