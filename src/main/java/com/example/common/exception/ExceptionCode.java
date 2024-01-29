package com.example.common.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {

	NO_DATA_IN_DB("조회된 데이터가 없습니다."),
	INVALID_INPUT_VALUE("유효하지 않는 입력값입니다."),
	;

	private final String message;

	ExceptionCode(String message) {
		this.message = message;
	}

}