package xyf.frpc.rpc.proxy;

public interface ProxyFactory {
	public Object getProxy(Class interfaceClass, Object target);
}
