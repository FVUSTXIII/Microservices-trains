package com.mocktrainservice.java.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer trainId;
	private String trainName;
	private Integer capacity;
	private Double trainType;
	private Double trainScore;
	
	public Integer getTrainId() {
		return trainId;
	}
	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
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
	
	

}
