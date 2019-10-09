package com.ril.base.dto;

public class RecordDto extends AnalyticDto {

	private static final long serialVersionUID = 1L;

	private long columnNo;
	private Object key;
	private Object value;
	private String greyOut;
	private String link;

	// Getter and Setter Method

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public long getColumnNo() {
		return columnNo;
	}

	public void setColumnNo(long columnNo) {
		this.columnNo = columnNo;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String isGreyOut() {
		return greyOut;
	}

	public void setGreyOut(String greyOut) {
		this.greyOut = greyOut;
	}
}
