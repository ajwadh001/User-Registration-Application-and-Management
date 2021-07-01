package com.example.Dto;

import java.util.Map;

public class ResponseError {

	private Map<Object, Object> message;

	public ResponseError(Map<Object, Object> message) {
		super();
		this.message = message;
	}

	public Map<Object, Object> getMessage() {
		return message;
	}

	public void setMessage(Map<Object, Object> message) {
		this.message = message;
	}
	
	

}