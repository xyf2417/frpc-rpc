package xyf.frpc.rpc.data;

public class Response {
	private Head head;
	private ResponseBody body;

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public ResponseBody getBody() {
		return body;
	}

	public void setBody(ResponseBody body) {
		this.body = body;
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Response(");
		res.append(body);
		res.append(")");

		return res.toString();
	}
}
