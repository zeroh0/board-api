package com.example.common.response;

import com.example.common.exception.ExceptionCode;
import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ExceptionResponse {

	private final String message;
	private final List<FieldError> errors;

	private ExceptionResponse(ExceptionCode exceptionCode) {
		this.message = exceptionCode.getMessage();
		this.errors = new ArrayList<>();
	}

	private ExceptionResponse(ExceptionCode exceptionCode, List<FieldError> fieldErrors) {
		this.message = exceptionCode.getMessage();
		this.errors = fieldErrors;
	}

	public static ExceptionResponse of(ExceptionCode exceptionCode) {
		return new ExceptionResponse(exceptionCode);
	}

	public static ExceptionResponse of(ExceptionCode exceptionCode, BindingResult bindingResult) {
		return new ExceptionResponse(exceptionCode, FieldError.of(bindingResult));
	}

	@Getter
	public static class FieldError {
		private final String field;
		private final String value;
		private final String message;

		 private FieldError(String field, String value, String message) {
    		this.field = field;
    		this.value = value;
    		this.message = message;
    	}

		public static List<FieldError> of(BindingResult bindingResult) {
			List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
			return fieldErrors.stream()
					.map(error -> new FieldError(
							error.getField(),
							error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
							error.getDefaultMessage()
					)).collect(Collectors.toList());
		}
	}

}
