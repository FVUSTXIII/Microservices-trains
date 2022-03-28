package com.trainservice.java.service;

import com.trainservice.java.dto.TrainResponseDTO;

public interface TrainService {
	
	TrainResponseDTO getAllTrainsDetails(Integer pageNo, Integer pageSize);

}
