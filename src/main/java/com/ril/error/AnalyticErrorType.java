package com.ril.error;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class AnalyticErrorType {
	private HttpStatus status;
	private String message;
	private List<String> errors;

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public AnalyticErrorType(HttpStatus status, String message,
			List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public AnalyticErrorType(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

}
