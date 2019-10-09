package com.ril.exception.exception;

public class PartnerAnalyticDaoException extends PartnerAnalyticSystemException {
	private static final long serialVersionUID = 1L;

	public PartnerAnalyticDaoException(int erorrCode, String message) {
		super(erorrCode, message);
	}

	public PartnerAnalyticDaoException(int erorrCode, String message, Throwable cause) {
		super(erorrCode, message, cause);
	}

	public PartnerAnalyticDaoException(int erorrCode, String message, int httpStatus) {
		super(erorrCode, message, httpStatus);
	}

	public PartnerAnalyticDaoException(int erorrCode, int httpStatus, String message,
			Throwable cause) {
		super(erorrCode, httpStatus, message, cause);
	}

	public PartnerAnalyticDaoException(int erorrCode, int httpStatus, String message,
			String[] msgArgs, Throwable cause) {
		super(erorrCode, httpStatus, message, msgArgs, cause);
	}

	public PartnerAnalyticDaoException(int erorrCode, int httpStatus, String message,
			String[] msgArgs) {
		super(erorrCode, httpStatus, message, msgArgs);
	}

}
