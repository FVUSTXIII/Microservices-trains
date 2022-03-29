package com.trainservice.java.dto;

public class RouteDto {
	private String source;
	private String destination;
	private Double routeCost;
	
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
	public Double getRouteCost() {
		return routeCost;
	}
	public void setRouteCost(Double routeCost) {
		this.routeCost = routeCost;
	}
	
	
}
