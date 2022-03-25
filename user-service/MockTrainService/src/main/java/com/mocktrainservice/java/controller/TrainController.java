package com.mocktrainservice.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mocktrainservice.java.dto.TripRequestDTO;
import com.mocktrainservice.java.dto.TripResponseDTO;
import com.mocktrainservice.java.service.TrainService;

@RestController
public class TrainController {
	
	@Autowired
	TrainService trainService;
	
	
	@PostMapping("/trips")
	public ResponseEntity<TripResponseDTO> getAllStoreDetails(
			@RequestParam(defaultValue = "0")Integer pageNo,
			@RequestParam(defaultValue = "5")Integer pageSize,
			@RequestBody TripRequestDTO tripRequestDTO) {
		TripResponseDTO storeResponseDto =  trainService.getTripsDetails(tripRequestDTO, pageNo, pageSize);
		return new ResponseEntity<TripResponseDTO>(storeResponseDto, HttpStatus.OK);
	}

}
