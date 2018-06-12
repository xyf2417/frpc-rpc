package xyf.frpc.rpc.proxy;

public interface ProxyFactory {
	public Object getProxy(Class cinterface, Object target);
}
