package com.puc.minhavaga.application.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorResponse {
	
	private List<String> errorMessages = null;
	private Map<String, String> errors = null;
	
	public ErrorResponse(List<String> errorMessages) {
		super();
		this.errorMessages = errorMessages;
	}
	
	public ErrorResponse(Map<String, String> errors) {
		super();
		this.errors = errors;
	}
	
	public ErrorResponse(String errorMessage) {
		super();
		this.errorMessages = new ArrayList<String>();
		this.addErrorMessage(errorMessage);
	}
	
	public ErrorResponse(String key, String value) {
		super();
		this.errors = new HashMap<String, String>();
		this.addError(key, value);
	}
	
	public void addErrorMessage(String error) {
		this.errorMessages.add(error);
	}
	
	public void addError(String key, String value) {
		this.errors.put(key, value);
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

}