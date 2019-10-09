package com.ril.base.dto;

import java.util.List;

/**
 * This class is used for return response with message and content
 * 
 */
public class ReturnMessageDto extends AnalyticDto {

	private static final long serialVersionUID = 1L;

	private int resultCode;
	// this record "errorType" code from Response Pattern, But
	// For BATCH PROCESSING it must be 99.
	// 1-System , 2-Business, 3-Success, 4-DAO/Database(JPA/Hibernate/JDBC),
	// 5- Communication (Messaging, web, mail, etc), 6-IO/File System,
	// 99-BatchUpdate

	// this will have possible values : SUCCESS/ ERROR/ VALIDATION/ BATCH
	private String messageKey;

	private Object returnObject;

	private List<String> responseParams;

	private ResponseDetailDto responseDetail;

	// Getter and Setter Method
	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public Object getReturnObject() {
		return returnObject;
	}

	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

	public List<String> getResponseParams() {
		return responseParams;
	}

	public void setResponseParams(List<String> responseParams) {
		this.responseParams = responseParams;
	}

	public ResponseDetailDto getResponseDetail() {
		return responseDetail;
	}

	public void setResponseDetail(ResponseDetailDto responseDetail) {
		this.responseDetail = responseDetail;
	}
}
