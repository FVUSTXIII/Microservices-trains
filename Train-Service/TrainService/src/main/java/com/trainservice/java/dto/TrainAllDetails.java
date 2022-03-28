package com.trainservice.java.dto;


public class TrainAllDetails {

	//private Integer trainId;
	private String trainName;
	private Integer capacity;
	private Double trainType;
	private Double trainScore;
	private ResponseDTO responseDTO;
	
	public ResponseDTO getResponseDTO() {
		return responseDTO;
	}
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.responseDTO = responseDTO;
	}

	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Double getTrainType() {
		return trainType;
	}
	public void setTrainType(Double trainType) {
		this.trainType = trainType;
	}
	public Double getTrainScore() {
		return trainScore;
	}
	public void setTrainScore(Double trainScore) {
		this.trainScore = trainScore;
	}
	/*
	 * public TrainAllDetails(String trainName, Integer capacity, Double trainType,
	 * Double trainScore) { this.trainName = trainName; this.capacity = capacity;
	 * this.trainType = trainType; this.trainScore = trainScore; }
	 */
	
	
	
	
	
}
