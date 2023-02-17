package com.springbootbackendapp.dto;

public class ApiResponse {

	private String message;
	private Boolean status;

	public ApiResponse(Boolean status, String message) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", status=" + status + "]";
	}

}
