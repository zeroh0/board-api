package com.example.common.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {

	NO_DATA_IN_DB(0, "데이터베이스에 값이 존재하지 않습니다.");

	private final int code;
	private final String msg;

	ExceptionCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

}