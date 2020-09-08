package com.self.spring.security.exceptionResponse;

public class SimpleErrorResponse {
	
	private Integer status;
	private String message;
	

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public SimpleErrorResponse() {
	}
	public SimpleErrorResponse(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	

}
