package xyf.frpc.rpc;

import java.util.concurrent.locks.LockSupport;

public class ResponseFuture {

	private Object result;
	
	
	public Object get() {
		LockSupport.park();
		return null;
	}
	
	
	public void setResult(Object res) {
		
	}
	
	
}
