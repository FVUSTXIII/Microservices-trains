package com.ticketservice.java.Exception;

public class TripsNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TripsNotFoundException(String message)
	{
		super(message);
	}

}
