package com.mocktrainservice.java.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trips {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripId;
	private Integer trainId;
	private Integer routeId;
	private LocalDate tripDate;
	private Double tripCost;
	public Integer getTripId() {
		return tripId;
	}
	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}
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
