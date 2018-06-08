package xyf.frpc.rpc;

public interface Result {
	
	
	public Object getValue();
	
	
	public ResultStatus getStatus();
	
	public void setValue(Object value);
	
	
	public void setStatus(ResultStatus status);
}
