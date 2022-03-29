package com.trainservice.java.service;

import com.trainservice.java.dto.RouteDto;
import com.trainservice.java.dto.TrainAllDetails;
import com.trainservice.java.dto.TrainAllResponseDTO;
import com.trainservice.java.dto.TrainResponseDTO;

public interface TrainService {
	
	TrainResponseDTO getAllTrainsDetails(Integer pageNo, Integer pageSize);
	
	TrainAllResponseDTO getTrainAllDetails(Integer trainId);

	RouteDto getRoute(Integer tripId);
	

}
