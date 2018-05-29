package com.ms;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyAdvisor {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception exception) {
		if (exception instanceof ValidationException) {
			ValidationException validationException = (ValidationException) exception;
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			                     .body(new ErrorObj().setCause(100)
			                                         .setMessage(validationException.getMessage()));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		                     .body(new ErrorObj().setCause(100)
		                                         .setMessage(exception.getMessage()));

	}

}
