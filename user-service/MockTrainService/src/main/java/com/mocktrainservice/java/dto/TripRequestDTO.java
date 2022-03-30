package com.mocktrainservice.java.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

public class TripRequestDTO {

	@NotEmpty(message = "Source should not be empty")
	private String source;
	@NotEmpty(message = "Destination should not be empty")
	private String destination;
<<<<<<< HEAD
	@NotEmpty(message = "Date should not be empty")
=======
	//@NotEmpty(message = "Date should not be empty")
>>>>>>> origin/user-service
	private LocalDate date;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	
}
