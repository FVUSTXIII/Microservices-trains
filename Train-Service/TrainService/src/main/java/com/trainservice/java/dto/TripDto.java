package com.trainservice.java.dto;

import java.time.LocalDate;

public class TripDto {
	
	private Integer trainId;
	private Integer routeId;
	private LocalDate tripDate;
	private Double tripCost;
	public Integer getTrainId() {
		return trainId;
	}
	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public LocalDate getTripDate() {
		return tripDate;
	}
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	public Double getTripCost() {
		return tripCost;
	}
	public void setTripCost(Double tripCost) {
		this.tripCost = tripCost;
	}
}
