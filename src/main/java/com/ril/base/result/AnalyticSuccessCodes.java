package com.ril.base.result;

import org.springframework.http.HttpStatus;

import com.ril.base.dto.ResultCode;

/**
 * success codes
 */
public enum AnalyticSuccessCodes implements ResultCode {

	
	FIND_API_FETCH_SUCCESS(302005007, "Information fetched successfully",
			HttpStatus.OK.value());

	private final int httpStatus;
	private final int resultCode;
	private final String message;

	AnalyticSuccessCodes(int resultCode, String message, int httpStatus) {
		this.httpStatus = httpStatus;
		this.resultCode = resultCode;
		this.message = message;
	}

	public int getResultCode() {
		return resultCode;
	}

	public String getMessage() {
		return message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}
}
