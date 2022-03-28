package com.trainservice.java.dto;

import java.util.ArrayList;
import java.util.List;



public class TrainResponseDTO {
	private List<TrainDetails> trainList = new ArrayList<>();
	private ResponseDTO responseDTO;
	public List<TrainDetails> getTrainList() {
		return trainList;
	}
	public void setTrainList(List<TrainDetails> trainList) {
		this.trainList = trainList;
	}
	public ResponseDTO getResponseDTO() {
		return responseDTO;
	}
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.responseDTO = responseDTO;
	}
	

	
	
	
	

}
