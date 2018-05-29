package xyf.frpc.rpc;

import xyf.frpc.config.Provider;

public abstract class AbstractInvoker<T> implements Invoker<T> {
	
	private Class<T> cInterface;
	
	private Provider provider;
	
	
	public void setInterface(Class<T> cInterface) {
		this.cInterface = cInterface;
	}
	
	public Class<T> getInterface() {
		// TODO Auto-generated method stub
		return cInterface;
	}
	
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
}
