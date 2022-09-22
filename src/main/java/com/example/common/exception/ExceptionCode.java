package com.example.common.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {

	NO_DATA_IN_DB(0, " 조회된 데이터가 없습니다."),

	INVALID_INPUT_VALUE(400, " 유효하지 않는 입력값입니다.")
	;

	private final int code;
	private final String msg;

	ExceptionCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

}