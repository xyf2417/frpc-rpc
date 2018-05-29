package xyf.frpc.rpc;


public interface Invoker<T> {
	/**
	 * 获取该Provider对应的接口
	 * @return
	 */
	public Class<T> getInterface();
	
	public Result invoke(Invocation invocation);


}
