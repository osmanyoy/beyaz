package com.ms;

public class ErrorObj {

	private String message;
	private int cause;

	public String getMessage() {
		return this.message;
	}

	public ErrorObj setMessage(String message) {
		this.message = message;
		return this;
	}

	public int getCause() {
		return this.cause;
	}

	public ErrorObj setCause(int cause) {
		this.cause = cause;
		return this;
	}

}
