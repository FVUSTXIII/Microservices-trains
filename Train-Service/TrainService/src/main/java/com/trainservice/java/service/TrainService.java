package com.trainservice.java.service;

import com.trainservice.java.dto.TrainAllResponseDTO;
import com.trainservice.java.dto.TrainResponseDTO;
import com.trainservice.java.dto.TripRequestDTO;
import com.trainservice.java.dto.TripResponseDTO;

public interface TrainService {
	
	TrainResponseDTO getAllTrainsDetails(Integer pageNo, Integer pageSize);
	
	TrainAllResponseDTO getTrainAllDetails(Integer trainId);
	
	TripResponseDTO getTripsDetails(TripRequestDTO tripRequestDTO, Integer pageNo, Integer pageSize);
	

}
