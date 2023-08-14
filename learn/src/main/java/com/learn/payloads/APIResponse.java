package com.learn.payloads;

public class APIResponse {
	
	private String message;
	public APIResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public APIResponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	private boolean success;
}
