package xyf.frpc.rpc;

public interface Result {
	
	/**
	 * ��ȡ����ֵ
	 * @return
	 */
	public Object getValue();
	
	/**
	 * ��ȡ�÷������õ�״̬
	 * @return
	 */
	public ResultStatus getStatus();
	
	public void setValue(Object value);
	
	
	public void setStatus(ResultStatus status);
}
