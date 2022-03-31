package com.ticketservice.java.Dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
public class TripToBookDTO {
	@Min(value = 1, message = "User Not Valid")
	private Integer userId;
	@Min(value = 1, message = "Trip Not Valid")
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
