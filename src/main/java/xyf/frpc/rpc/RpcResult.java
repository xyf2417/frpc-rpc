package xyf.frpc.rpc;

public class RpcResult implements Result {

	private Object value;
	
	private ResultStatus status;
	
	public Object getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public ResultStatus getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void setStatus(ResultStatus status) {
		this.status = status;
	}

}
