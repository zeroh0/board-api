package com.example.common.exception;

import lombok.Getter;

@Getter
public class NoDataException extends RuntimeException {

	private final ExceptionCode exceptionCode;

	public NoDataException() {
		this.exceptionCode = ExceptionCode.NO_DATA_IN_DB;
	}

}