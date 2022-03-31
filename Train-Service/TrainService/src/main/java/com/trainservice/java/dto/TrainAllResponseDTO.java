package com.trainservice.java.dto;

import java.util.ArrayList;
import java.util.List;

public class TrainAllResponseDTO {
	
	private TrainAllDetails trainAllDetails = new TrainAllDetails();
	private ResponseDTO responseDTO;
	public TrainAllDetails getTrainAllDetails() {
		return trainAllDetails;
	}
	public void setTrainAllDetails(TrainAllDetails trainAllDetails) {
		this.trainAllDetails = trainAllDetails;
	}
	public ResponseDTO getResponseDTO() {
		return responseDTO;
	}
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.responseDTO = responseDTO;
	}
	

}
