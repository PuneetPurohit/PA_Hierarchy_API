package com.ril.base.dto;

import java.io.Serializable;

/**
 * This class is used for conversion of json to pojo and vice versa.
 * 
 *
 */
public class ApiResponseDto<T> extends AnalyticDto implements Serializable  {

	private static final long serialVersionUID = 1L;

	// This is related to Http code
	private int status;

	// This record "errorType" code from Response Pattern, But
	// For BATCH PROCESSING it must be 99.
	// 1-System , 2-Business, 3-Success, 4-DAO/Database(JPA/Hibernate/JDBC),
	// 5- Communication (Messaging, web, mail, etc), 6-IO/File System,
	// 99-BatchUpdate
	private int code;

	// This will have possible values : SUCCESS/ ERROR/ VALIDATION/ BATCH
	private String message;

	// In case of List system will return RecordsConfigDto
	// otherwise single Dto
	private T content;

	private ResponseDetailDto responseDetail;

	// Getter and Setter Method
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public ResponseDetailDto getResponseDetail() {
		return responseDetail;
	}

	public void setResponseDetail(ResponseDetailDto responseDetail) {
		this.responseDetail = responseDetail;
	}

	public void setResult(ResultCode resultCode) {
		this.status = resultCode.getHttpStatus();
		this.code = resultCode.getResultCode();
		this.message = resultCode.getMessage();
	}
}