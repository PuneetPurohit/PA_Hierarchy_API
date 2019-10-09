package com.ril.base.enumeration;

public enum ResponseCode {

	SYSTEM(1) {
	},
	BUSINESS(2) {
	},
	SUCCESS(3) {
	},
	DAO_DATABASE(4) {
	},
	COMMUNICATION(5) {
	},
	IO_FILE(6) {
	};

	int code;

	ResponseCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
