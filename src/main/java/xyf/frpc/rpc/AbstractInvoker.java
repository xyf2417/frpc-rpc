package xyf.frpc.rpc;

import xyf.frpc.config.Provider;

public abstract class AbstractInvoker<T> implements Invoker<T> {
	
	private Class<T> cInterface;
	
	private Object proxy;
	
	
	public void setInterface(Class<T> cInterface) {
		this.cInterface = cInterface;
	}
	
	public Class<T> getInterface() {
		// TODO Auto-generated method stub
		return cInterface;
	}

	public Object getProxy() {
		return proxy;
	}

	public void setProxy(Object proxy) {
		this.proxy = proxy;
	}
	
	
	
}
