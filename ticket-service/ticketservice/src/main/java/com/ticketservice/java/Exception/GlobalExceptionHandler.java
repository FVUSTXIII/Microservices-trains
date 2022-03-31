package com.ticketservice.java.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;





@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity <ValidationErrorResponse> handleException(MethodArgumentNotValidException ex)
	{
		ValidationErrorResponse errorResponse = new ValidationErrorResponse("Invalid Arguments Passed", "MA400");
		ex.getBindingResult().getFieldErrors().stream().forEach(error -> {
			errorResponse.getInvalidArguments().put(error.getField(),error.getDefaultMessage());
		});
		
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ValidationErrorResponse>(errorResponse, HttpStatus.OK);
	}
	
	@ExceptionHandler(TripsNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(TripsNotFoundException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),"TR404");
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity <ErrorResponse>(errorResponse, HttpStatus.OK);
	}	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(UserNotFoundException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "US404");
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity <ErrorResponse>(errorResponse, HttpStatus.OK);
	}

}
