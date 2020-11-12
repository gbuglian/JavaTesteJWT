package br.salaoEveris.app.response;

public class BaseResponse {
	
	public String message;
	public int statusCode;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		statusCode = statusCode;
	}
}
