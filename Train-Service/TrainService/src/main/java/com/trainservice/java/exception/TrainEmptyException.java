package com.trainservice.java.exception;

public class TrainEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TrainEmptyException(String message)
	{
		super(message);
	}

}
