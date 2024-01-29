package com.example.common.controller;

import com.example.common.exception.ExceptionCode;
import com.example.common.exception.NoDataException;
import com.example.common.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Handles MethodArgumentNotValidException and returns a ResponseEntity with an ExceptionResponse object.
	 *
	 * @param e The MethodArgumentNotValidException to be handled.
	 * @param bindingResult The BindingResult object containing validation errors.
	 * @return A ResponseEntity object with an ExceptionResponse body and HTTP status code of 400 (Bad Request).
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, BindingResult bindingResult) {
		log.error("handleMethodArgumentNotValidException", e);
		ExceptionResponse response = ExceptionResponse.of(ExceptionCode.INVALID_INPUT_VALUE, bindingResult);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handles a NoDataException and returns a ResponseEntity with an ExceptionResponse object.
	 *
	 * @param e The NoDataException to be handled.
	 * @return A ResponseEntity object with an ExceptionResponse body and HTTP status code of 404 (Not Found).
	 */
	@ExceptionHandler(NoDataException.class)
	public ResponseEntity<ExceptionResponse> handleNoDataException(NoDataException e) {
		log.error("handleNoDataException", e);
		ExceptionResponse response = ExceptionResponse.of(ExceptionCode.INVALID_INPUT_VALUE);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}