package com.ms;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class MyRemoteEvent extends RemoteApplicationEvent {

	private static final long serialVersionUID = 9222105044019378424L;
	private String message;

	public MyRemoteEvent() {
	}

	public MyRemoteEvent(Object source,
	                     String uniqueId,
	                     String message) {
		super(source, uniqueId);
		this.setMessage(message);
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
