package com.ril.base.dto;

/**
 * this class is used for conversion of json to pojo and vice versa.
 * 
 * 
 *
 */

public class RedirectConfigDto extends AnalyticDto {
	private static final long serialVersionUID = 1L;
	
	private String callNumber;

	// Getter and Setter Method
	

	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

}
