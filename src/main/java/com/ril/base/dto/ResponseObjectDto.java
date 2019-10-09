package com.ril.base.dto;

/**
 * This class is used to handle response
 * error/success/exception/validation/warning/etc
 * 
 */
public class ResponseObjectDto extends AnalyticDto {
	private static final long serialVersionUID = 1L;

	private String fieldName; // userId (user dto member name)
	private String message; // DetailMessage: Not able to create user id 2345
	private String code; // EX: 20010210801

	// constructor
	public ResponseObjectDto(){
		super();
	}
	public ResponseObjectDto(String fieldName, String message, int code) {
		super();
		this.fieldName = fieldName;
		this.message = message;
		this.code = String.valueOf(code);
	}

	public ResponseObjectDto(String fieldName, ResultCode result) {
		this(fieldName, result.getMessage(), result.getResultCode());
	}

	// getters and setters
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ResponseObjectDto [fieldName=" + fieldName + ", message="
				+ message + ", code=" + code + "]";
	}

}
