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
}
