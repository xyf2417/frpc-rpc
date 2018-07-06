package xyf.frpc.rpc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;

public class ResponseFuture {
	
	/**
	 * Invocation id <-> ResponseFuture
	 */
	private static final Map<Long, ResponseFuture> FUTURES = new ConcurrentHashMap<Long, ResponseFuture>();

	private volatile Object result;
	
	/**
	 * Thread which waits for this future
	 */
	private volatile Thread t;
	
	public ResponseFuture(Invocation invocation) {
		FUTURES.put(invocation.getInvokerId(), this);
	}
	
	
	/**
	 * Get the result of this future, will block until other thread call the setResult() method.
	 * 
	 * @return
	 */
	public Object get() {
		t = Thread.currentThread();
		LockSupport.park();
		return result;
	}
	
	
	public void setResult(Object res) {
		this.result = res;
		LockSupport.unpark(this.t);
	}
	
	public static ResponseFuture getFuture(Long id) {
		return FUTURES.get(id);
	}
	
}
