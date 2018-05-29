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
}
