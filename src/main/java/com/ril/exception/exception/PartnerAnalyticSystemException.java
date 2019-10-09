package com.ril.exception.exception;

public class PartnerAnalyticSystemException extends PartnerAnalyticException {

	private static final long serialVersionUID = 1L;

	public PartnerAnalyticSystemException(int erorrCode, String message) {
		super(erorrCode, message);
	}

	public PartnerAnalyticSystemException(int erorrCode, String message, Throwable cause) {
		super(erorrCode, message, cause);
	}

	public PartnerAnalyticSystemException(int erorrCode, String message, int httpStatus) {
		super(erorrCode, message, httpStatus);
	}

	public PartnerAnalyticSystemException(int erorrCode, int httpStatus, String message,
			Throwable cause) {
		super(erorrCode, httpStatus, message, cause);
	}

	public PartnerAnalyticSystemException(int erorrCode, int httpStatus, String message,
			String[] msgArgs, Throwable cause) {
		super(erorrCode, httpStatus, message, msgArgs, cause);
	}

	public PartnerAnalyticSystemException(int erorrCode, int httpStatus, String message,
			String[] msgArgs) {
		super(erorrCode, httpStatus, message, msgArgs);
	}

}
