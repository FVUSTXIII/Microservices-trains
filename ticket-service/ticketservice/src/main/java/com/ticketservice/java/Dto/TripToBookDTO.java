package com.ticketservice.java.Dto;

import javax.validation.constraints.NotNull;

public class TripToBookDTO {
	@NotNull(message = "userId should not be null")
	private Integer userId;
	@NotNull(message = "tripId should not be null")
	private Integer tripId;
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getTripId() {
		return tripId;
	}
	
	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}
	
}
