package xyf.frpc.rpc;


public interface Invoker<T> {

	public Class<T> getInterface();
	
	public void setInterface(Class<T> cInterface);
	
	public Result invoke(Invocation invocation);


}
