package xyf.frpc.rpc.data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class RequestBody implements Serializable {

	private static final long serialVersionUID = 2946565368837555734L;
	
	private final static AtomicLong id = new AtomicLong(1);
	
	private long invokeId;

	private String interfaceFullName;

	private String methodName;

	private Class[] parameterTypes;
	
	private EventType eventType;

	private Object[] arguments;
	
	private Object event;

	public String getInterfaceFullName() {
		return interfaceFullName;
	}

	public void setInterfaceFullName(String interfaceFullName) {
		this.interfaceFullName = interfaceFullName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Class[] getParameterTypes() {
		return parameterTypes;
	}

	public void setParameterTypes(Class[] parameterTypes) {
		this.parameterTypes = parameterTypes;
	}

	public Object[] getArguments() {
		return arguments;
	}

	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}
	
	public static long nextInvokeId() {
		return id.getAndIncrement();
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
	
	public String toString(){
		if(eventType == EventType.RPC) {
			StringBuilder res = new StringBuilder("Request(");
			res.append("invokeId=" + invokeId);
			res.append("," + interfaceFullName + ".");
			res.append(methodName + "(");
			res.append(Arrays.toString(parameterTypes));
			res.append(")");
			return res.toString();
		} else {
			return "Request(HEART_BEAT)";
		}
	}

	public static enum EventType {
		HEART_BEAT,
		RPC
	}

}
