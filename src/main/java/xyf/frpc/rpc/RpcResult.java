package xyf.frpc.rpc;

import java.io.Serializable;

public class RpcResult implements Result, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Result(");
		res.append("status:" + status);
		if(value != null){
			res.append(", value:" + value);
		}
		res.append(")");
		return res.toString();
	}
}
