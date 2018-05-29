package xyf.frpc.rpc;

public interface Result {
	
	/**
	 * 获取返回值
	 * @return
	 */
	public Object getValue();
	
	/**
	 * 获取该方法调用的状态
	 * @return
	 */
	public ResultStatus getStatus();
}
