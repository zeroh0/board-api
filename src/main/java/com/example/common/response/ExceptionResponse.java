package com.example.common.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExceptionResponse {

	private int code;
	private String message;

	@Builder
	public ExceptionResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}

}
