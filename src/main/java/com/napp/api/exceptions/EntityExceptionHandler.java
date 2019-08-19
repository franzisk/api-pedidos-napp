package com.napp.api.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class EntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorMessage errorObj = new ErrorMessage(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(SaveUpdateException.class)
	public final ResponseEntity<ErrorMessage> handleSaveUpdateExceptions(SaveUpdateException ex, WebRequest request) {
		String details = request.getDescription(false);
		ErrorMessage errorObj = new ErrorMessage(new Date(), ex.getMessage(), details);
		return new ResponseEntity<>(errorObj, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
	}
}
