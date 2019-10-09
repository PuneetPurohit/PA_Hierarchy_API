package com.ril.exception.exception;



public class PartnerAnalyticException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int httpStatus;
	private int errorCode;
	private String[] msgArgs;

	public int getHttpStatus() {
		return httpStatus;
	}

	public int getErorrCode() {
		return errorCode;
	}

	public String[] getMsgArgs() {
		return msgArgs;
	}

	public PartnerAnalyticException(int erorrCode, String message) {
		super(message);
		this.errorCode = erorrCode;
	}

	public PartnerAnalyticException(int erorrCode, String message, int httpStatus) {
		super(message);
		this.errorCode = erorrCode;
		this.httpStatus = httpStatus;
	}

	public PartnerAnalyticException(int erorrCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = erorrCode;
	}

	public PartnerAnalyticException(int erorrCode, int httpStatus, String message,
			Throwable cause) {
		super(message, cause);
		this.errorCode = erorrCode;
		this.httpStatus = httpStatus;
	}

	public PartnerAnalyticException(int erorrCode, int httpStatus, String message,
			String[] msgArgs) {
		super(message);
		this.errorCode = erorrCode;
		this.httpStatus = httpStatus;
		if (msgArgs.length > 0) {
			this.msgArgs = msgArgs;
		}
	}

	public PartnerAnalyticException(int erorrCode, int httpStatus, String message,
			String[] msgArgs, Throwable cause) {
		super(message, cause);
		this.errorCode = erorrCode;
		this.httpStatus = httpStatus;
		if (msgArgs.length > 0) {
			this.msgArgs = msgArgs;
		}
	}

}
