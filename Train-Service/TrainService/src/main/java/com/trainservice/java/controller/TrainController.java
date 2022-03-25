package com.trainservice.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainservice.java.dto.TrainResponseDTO;
import com.trainservice.java.service.TrainService;

@RestController
public class TrainController {
	
	@Autowired
	TrainService trainService;
	//FALTAN LOS SERVICES Y EL REPO
	@GetMapping("/trains")
	public ResponseEntity<TrainResponseDTO> getAllStoreDetails(
			@RequestParam(defaultValue = "0")Integer pageNo,
			@RequestParam(defaultValue = "5")Integer pageSize) {
		TrainResponseDTO storeResponseDto =  trainService.getAllTrainsDetails(pageNo, pageSize);
		return new ResponseEntity<TrainResponseDTO>(storeResponseDto, HttpStatus.OK);
	}

}
