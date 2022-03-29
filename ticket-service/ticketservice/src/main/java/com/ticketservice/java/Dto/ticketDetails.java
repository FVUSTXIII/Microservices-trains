package com.ticketservice.java.Dto;

import java.time.LocalDateTime;

public class ticketDetails {
	private Integer ticketId;
	private Integer tripId;
	private RouteDTO route;
	private LocalDateTime tripDate;
	private Double tripCost;
	private LocalDateTime ticketDate;
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public Integer getTripId() {
		return tripId;
	}
	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}
	public RouteDTO getRoute() {
		return route;
	}
	public void setRoute(RouteDTO route) {
		this.route = route;
	}
	public LocalDateTime getTripDate() {
		return tripDate;
	}
	public void setTripDate(LocalDateTime tripDate) {
		this.tripDate = tripDate;
	}
	public Double getTripCost() {
		return tripCost;
	}
	public void setTripCost(Double tripCost) {
		this.tripCost = tripCost;
	}
	public LocalDateTime getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(LocalDateTime ticketDate) {
		this.ticketDate = ticketDate;
	}
	
	
}
