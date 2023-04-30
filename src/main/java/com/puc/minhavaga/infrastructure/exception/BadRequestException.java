package com.puc.minhavaga.infrastructure.exception;

public class BadRequestException extends Exception {
	
	private static final long serialVersionUID = -5973989969977920938L;
	
	private String field;
	
	private String message;
	
	public BadRequestException(String message) {
		super();
		this.message = message;
	}
	
	public BadRequestException(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
	
}