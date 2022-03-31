package com.trainservice.java.dto;

import java.util.ArrayList;
import java.util.List;


public class TripResponseDTO {

	private List<TripDetails> tripDetails = new ArrayList<>();
	private ResponseDTO responseDTO;
	
	public List<TripDetails> getTripDetails() {
		return tripDetails;
	}
	public void setTripDetails(List<TripDetails> tripDetails) {
		this.tripDetails = tripDetails;
	}
	public ResponseDTO getResponseDTO() {
		return responseDTO;
	}
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.responseDTO = responseDTO;
	}
	
	
}
