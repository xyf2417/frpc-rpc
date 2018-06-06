package xyf.frpc.rpc;


public interface Invoker<T> {
	/**
	 * ��ȡ��Provider��Ӧ�Ľӿ�
	 * @return
	 */
	public Class<T> getInterface();
	
	public void setInterface(Class<T> cInterface);
	
	public Result invoke(Invocation invocation);


}
