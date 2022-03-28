package com.trainservice.java.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trainservice.java.constants.ApiConstants;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TrainListEmptyException.class)
	public ResponseEntity<ErrorResponse> handleException(TrainListEmptyException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ApiConstants.TRAIN_LIST_EMPTY);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity <ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	

}
