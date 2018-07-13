package xyf.frpc.rpc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ResponseFuture {
	
	private ReentrantLock lock = new ReentrantLock();
	
	private Condition done = lock.newCondition();
	
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
		if(!isDone()) {
			lock.lock();
			try{
				while(!isDone()) {
					done.await();
				}
			} catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
				lock.unlock();
			}
		}
		return result;
	}
	
	
	public void setResult(Object res) {
		lock.lock();
        try {
            result  = res;
            if (done != null) {
                done.signal();
            }
        } finally {
            lock.unlock();
        } 
	}
	
	public static ResponseFuture getFuture(Long id) {
		return FUTURES.get(id);
	}
	
	public boolean isDone() {
		return result != null;
	}
	
}
