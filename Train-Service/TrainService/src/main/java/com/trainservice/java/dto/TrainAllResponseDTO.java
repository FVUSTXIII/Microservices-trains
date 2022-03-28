package com.trainservice.java.dto;

import java.util.ArrayList;
import java.util.List;

public class TrainAllResponseDTO {
	
	private List<TrainAllDetails> trainAllDetailsList = new ArrayList<>();
	private ResponseDTO responseDTO;
	public List<TrainAllDetails> getTrainAllDetailsList() {
		return trainAllDetailsList;
	}
	public void setTrainAllDetailsList(List<TrainAllDetails> trainAllDetailsList) {
		this.trainAllDetailsList = trainAllDetailsList;
	}
	public ResponseDTO getResponseDTO() {
		return responseDTO;
	}
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.responseDTO = responseDTO;
	}
	
	
	

}
