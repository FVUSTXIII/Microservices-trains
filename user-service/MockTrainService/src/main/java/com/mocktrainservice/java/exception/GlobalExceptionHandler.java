package com.mocktrainservice.java.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mocktrainservice.java.constants.ApiConstants;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RouteNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(RouteNotFoundException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ApiConstants.ROUTE_NOT_FOUND);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity <ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	
	@ExceptionHandler(TripsNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(TripsNotFoundException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ApiConstants.TRIP_NOT_FOUND);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity <ErrorResponse>(errorResponse, HttpStatus.OK);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity <ValidationErrorResponse> handleException(MethodArgumentNotValidException ex)
	{
		ValidationErrorResponse errorResponse = new ValidationErrorResponse("Invalid Arguments Passed", ApiConstants.INVALID_ARGS);
		ex.getBindingResult().getFieldErrors().stream().forEach(error -> {
			errorResponse.getInvalidArguments().put(error.getField(),error.getDefaultMessage());
		});
		
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ValidationErrorResponse>(errorResponse, HttpStatus.OK);
	}
}
