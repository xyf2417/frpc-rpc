package xyf.frpc.rpc;


public interface Invoker<T> {
	/**
	 * ��ȡ��Provider��Ӧ�Ľӿ�
	 * @return
	 */
	public Class<T> getInterface();
	
	public Result invoke(Invocation invocation);


}
