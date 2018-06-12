package xyf.frpc.rpc;


public abstract class AbstractInvoker<T> implements Invoker<T> {
	
	private Class<T> interfaceClass;
	
	private Object proxy;
	
	
	public void setInterface(Class<T> cInterface) {
		this.interfaceClass = cInterface;
	}
	
	public Class<T> getInterface() {
		return interfaceClass;
	}

	public Object getProxy() {
		return proxy;
	}

	public void setProxy(Object proxy) {
		this.proxy = proxy;
	}
	
	
	
}
