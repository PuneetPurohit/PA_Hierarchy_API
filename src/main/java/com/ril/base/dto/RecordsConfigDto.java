package com.ril.base.dto;

/**
 * This class is used to send list of records with pagination
 * 
 *
 */
public class RecordsConfigDto<T> extends AnalyticDto {
	private static final long serialVersionUID = 1L;

	private int currentPageNo;
	private int totalRecords;
	// private Object records;
	private T records;

	// Getter and Setter methods
	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public T getRecords() {
		return records;
	}

	public void setRecords(T records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "RecordsConfigDto [currentPageNo=" + currentPageNo
				+ ", totalRecords=" + totalRecords + ", records=" + records
				+ "]";
	}

}
