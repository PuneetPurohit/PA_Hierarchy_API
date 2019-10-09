package com.ril.base.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import com.ril.base.dto.ApiResponseDto;
import com.ril.base.dto.ResponseDetailDto;
import com.ril.base.dto.ResponseObjectDto;
import com.ril.base.enumeration.ResponseCode;
import com.ril.base.enumeration.ResponseMessageType;
import com.ril.exception.exception.PartnerAnalyticException;
import com.ril.util.CommonUtil;

/**
 * Abstract class user to declare some common methods
 * 
 *
 */
@RestController
public abstract class AbstractApiController extends BaseAnalyticController{

	private static final Logger logger = LogManager.getLogger(AbstractApiController.class);
	/**
	 * This method is used to set ApiResponseDto
	 * 
	 * @param t
	 *            {@link T} contains natural object
	 * @param httpStatus
	 *            Integer value containing status code
	 * @param httpResponse
	 *            {@link HttpServletResponse}
	 * @param apiResponseDto
	 *            {@link ApiResponseDto} contains the status, code and message.
	 * @param responseDetailDto
	 *            {@link ResponseDetailDto} response details
	 * @param <T>
	 *            type of return object
	 */
	protected <T> void setResult(T t, int httpStatus, HttpServletResponse httpResponse,
			ApiResponseDto<T> apiResponseDto, ResponseDetailDto responseDetailDto) {
		// set response
		httpResponse.setStatus(httpStatus);

		// set api response
		apiResponseDto.setStatus(httpStatus);
		apiResponseDto.setCode(ResponseCode.SUCCESS.getCode());
		apiResponseDto.setMessage(ResponseMessageType.SUCCESS.toString());

		// set content
		apiResponseDto.setContent(t);

		// set response details
		apiResponseDto.setResponseDetail(responseDetailDto);

		if (responseDetailDto != null) {
			if (logger.isInfoEnabled()
					&& !CollectionUtils.isEmpty(responseDetailDto.getSuccessDetail())) {
				logger.info("Success : " + responseDetailDto.getSuccessDetail().toString());
			}
			if (logger.isWarnEnabled()
					&& !CollectionUtils.isEmpty(responseDetailDto.getWarningDetail())) {
				logger.warn("Success : " + responseDetailDto.getWarningDetail().toString());
			}
			if (logger.isInfoEnabled()
					&& !CollectionUtils.isEmpty(responseDetailDto.getValidationDetail())) {
				logger.info("Success : " + responseDetailDto.getValidationDetail().toString());
			}
		}

		if (t != null) {
			if (logger.isInfoEnabled()) {
				logger.info("Content : " + t.toString());
			}
		}
	}

	/**
	 * This method is used to handle exception
	 * 
	 * @param response
	 *            {@link HttpServletResponse} contains response
	 * @param apiResponseDto
	 *            {@link ApiResponseDto} contains the status, code and message
	 * @param exception
	 *            {@link ZodiacException} reference to exception
	 * @param t
	 *            {@link T} contains natural object
	 * @param <T>
	 *            type of return object
	 */
	protected <T> void handleAnalyticException(HttpServletResponse response,
			ApiResponseDto<T> apiResponseDto, PartnerAnalyticException exception, T t) {

		// set response
		response.setStatus(exception.getHttpStatus());

		// set api response : This code only handles Error Codes 9
		int firstDigit = Integer.parseInt(String.valueOf(String.valueOf(exception.getErorrCode())
				.charAt(0)));
		switch (firstDigit) {
		case 1: // System Exception
			apiResponseDto.setCode(ResponseCode.SYSTEM.getCode());
			break;
		case 2: // Business Exception
			apiResponseDto.setCode(ResponseCode.BUSINESS.getCode());
			break;
		case 4: // Database Exception
			apiResponseDto.setCode(ResponseCode.DAO_DATABASE.getCode());
			break;
		case 5: // Communication Exception
			apiResponseDto.setCode(ResponseCode.COMMUNICATION.getCode());
			break;
		case 6: // IO Exception
			apiResponseDto.setCode(ResponseCode.IO_FILE.getCode());
			break;
		default: // As of now treating all unqualified exceptions fall under
					// system exception
			apiResponseDto.setCode(ResponseCode.SYSTEM.getCode());
			break;
		}

		apiResponseDto.setStatus(exception.getHttpStatus());
		apiResponseDto.setMessage(ResponseMessageType.ERROR.toString());

		// set content
		apiResponseDto.setContent(t);

		// set response details
		ResponseDetailDto responseDetailDto = new ResponseDetailDto();
		ResponseObjectDto errorDetail = new ResponseObjectDto(null,
				CommonUtil.addArgumentInMessage(exception.getMessage(),
						(exception.getMsgArgs() != null) ? Arrays.asList(exception.getMsgArgs())
								: null), exception.getErorrCode());
		responseDetailDto.getErrorDetail().add(errorDetail);
		apiResponseDto.setResponseDetail(responseDetailDto);

		if (firstDigit == 2) {
			if (StringUtils.isNoneBlank(exception.getMsgArgs())) {
				logger.warn(CommonUtil.addArgumentInMessage(exception.getMessage(), (exception
						.getMsgArgs() != null) ? Arrays.asList(exception.getMsgArgs()) : null),
						exception);
			} else {
				logger.warn(exception.getMessage(), exception);
			}

		} else {
			if (StringUtils.isNoneBlank(exception.getMsgArgs())) {
				logger.error(CommonUtil.addArgumentInMessage(exception.getMessage(), (exception
						.getMsgArgs() != null) ? Arrays.asList(exception.getMsgArgs()) : null),
						exception);
			} else {
				logger.error(exception.getMessage(), exception);
			}
		}

		if (t != null) {
			if (logger.isInfoEnabled()) {
				logger.info("Content : " + t.toString());
			}
		}
	}
	

	/**
	 * This method is used to set ApiResponseDto with error type
	 * 
	 * @param response
	 *            {@link HttpServletResponse} contains response
	 * @param apiResponseDto
	 *            {@link ApiResponseDto} contains the status, code and message
	 * @param responseDetailDto
	 *            {@link ResponseDetailDto} response details
	 * @param <T>
	 *            type of return object
	 */
	protected <T> void setErrorResult(HttpServletResponse response,
			ApiResponseDto<T> apiResponseDto, ResponseDetailDto responseDetailDto) {

		response.setStatus(HttpStatus.BAD_REQUEST.value());

		apiResponseDto.setStatus(HttpStatus.BAD_REQUEST.value());
		apiResponseDto.setCode(ResponseCode.BUSINESS.getCode());
		apiResponseDto.setMessage(ResponseMessageType.ERROR.toString());
		apiResponseDto.setResponseDetail(responseDetailDto);

		if (responseDetailDto != null) {
			if (logger.isErrorEnabled()
					&& !CollectionUtils.isEmpty(responseDetailDto.getErrorDetail())) {
				logger.warn("Error : " + responseDetailDto.getErrorDetail().toString());
			}
		}
	}
}