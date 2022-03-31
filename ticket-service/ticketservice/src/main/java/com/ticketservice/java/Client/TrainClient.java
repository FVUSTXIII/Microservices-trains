package com.ticketservice.java.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ticketservice.java.Dto.RouteDTO;
import com.ticketservice.java.Dto.TripDTO;

@FeignClient("TRAINSERVICE")
public interface TrainClient {
	
	@GetMapping("/trainservice/train/trip/{tripId}/route")
	public RouteDTO getRouteByTripId(@PathVariable("tripId") Integer tripId);
	
	@GetMapping("/trainservice/trips/{tripId}")
	public TripDTO getTripById(@PathVariable("tripId") Integer tripId);
	
	@GetMapping("/trainservice/VerifyConnection")
	public String verifyConnection();

}

