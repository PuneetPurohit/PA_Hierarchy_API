package com.ril.exception.exception;

public class PartnerAnalyticBusinessException extends PartnerAnalyticSystemException {
	private static final long serialVersionUID = 1L;

	public PartnerAnalyticBusinessException(int erorrCode, String message) {
		super(erorrCode, message);
	}

	public PartnerAnalyticBusinessException(int erorrCode, String message, Throwable cause) {
		super(erorrCode, message, cause);
	}

	public PartnerAnalyticBusinessException(int erorrCode, String message, int httpStatus) {
		super(erorrCode, message, httpStatus);
	}

	public PartnerAnalyticBusinessException(int erorrCode, int httpStatus, String message,
			Throwable cause) {
		super(erorrCode, httpStatus, message, cause);
	}

	public PartnerAnalyticBusinessException(int erorrCode, int httpStatus, String message,
			String[] msgArgs, Throwable cause) {
		super(erorrCode, httpStatus, message, msgArgs, cause);
	}

	public PartnerAnalyticBusinessException(int erorrCode, int httpStatus, String message,
			String[] msgArgs) {
		super(erorrCode, httpStatus, message, msgArgs);
	}

}
