package com.hnguyen387.handle_exception.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(FailedToSaveData.class)
	public ResponseEntity<Object> handleFailedToSaveData(FailedToSaveData exption) {
		ErrorDetails error = new ErrorDetails();
		error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
		error.setErrMessage(exption.getMessage());
		error.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(NotFoundException exception) {
		ErrorDetails error = new ErrorDetails();
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatus(HttpStatus.NOT_FOUND.name());
		error.setErrMessage(exception.getMessage());
		error.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}
}
