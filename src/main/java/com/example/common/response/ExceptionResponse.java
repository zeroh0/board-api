package com.example.common.response;

import com.example.common.exception.ExceptionCode;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ExceptionResponse {

	private int code;
	private String message;

	@Builder
	public ExceptionResponse(ExceptionCode exceptionCode) {
		this.code = exceptionCode.getCode();
		this.message = exceptionCode.getMsg();
	}

}
