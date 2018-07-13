package xyf.frpc.rpc.data;

import java.io.Serializable;


public class ResponseBody implements Serializable {

	private static final long serialVersionUID = 5069245610440340300L;

	private Object returnValue;
	
	private long invokeId;
	
	private EventType eventType;
	
	private Object event;

	public Object getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(Object returnValue) {
		this.returnValue = returnValue;
	}

	public String toString() {
		return returnValue.toString();
	}
	
	public long getInvokeId() {
		return invokeId;
	}

	public void setInvokeId(long invokeId) {
		this.invokeId = invokeId;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Object getEvent() {
		return event;
	}

	public void setEvent(Object event) {
		this.event = event;
	}

	public static enum EventType {
		HEART_BEAT,
		RPC
	}
}
