package com.puc.minhavaga.infrastructure.exception;

public class InternalServerErrorException extends Exception {
	
	private static final long serialVersionUID = 3002505854958295752L;
	
	private String message;
	
	public InternalServerErrorException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	

}
