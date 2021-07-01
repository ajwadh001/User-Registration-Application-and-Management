package com.example.Dto;



public class ResponseDto {


	private Object data;
	private ResponseError error;
	
	public ResponseDto( Object data, ResponseError error) {
		super();
		
		this.data = data;
		this.error = error;
	}
	
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResponseError getError() {
		return error;
	}
	public void setError(ResponseError error) {
		this.error = error;
	}
	

	
	


}
