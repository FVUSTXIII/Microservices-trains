package com.mocktrainservice.java.dto;

import java.time.LocalDate;
import java.util.Optional;

import com.mocktrainservice.java.entity.Route;

public class TripDetails {

	private Integer tripId;
	private String trainName;
	private Optional<Route> route;
	private LocalDate tripDate;
	private Double tripCost;
	
	public Integer getTripId() {
		return tripId;
	}
	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public Optional<Route> getRoute() {
		return route;
	}
	public void setRoute(Optional<Route> optional) {
		this.route = optional;
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
