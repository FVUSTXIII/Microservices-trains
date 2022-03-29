package com.trainservice.java.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainservice.java.dto.RouteDto;
import com.trainservice.java.dto.TrainAllDetails;
import com.trainservice.java.dto.TrainAllResponseDTO;
import com.trainservice.java.dto.TrainResponseDTO;
import com.trainservice.java.service.TrainService;

@RestController
public class TrainController {
	
	@Autowired
	TrainService trainService;
	//FALTAN LOS SERVICES Y EL REPO
	@GetMapping("/trains")
	public ResponseEntity<TrainResponseDTO> getAllTrainDetails(
			@RequestParam(defaultValue = "0")Integer pageNo,
			@RequestParam(defaultValue = "5")Integer pageSize) {
		TrainResponseDTO storeResponseDto =  trainService.getAllTrainsDetails(pageNo, pageSize);
		return new ResponseEntity<TrainResponseDTO>(storeResponseDto, HttpStatus.OK);
	}
	
	
	@GetMapping("/train/{trainId}")
	public ResponseEntity<TrainAllResponseDTO> getTrainInfo(@PathVariable("trainId") Integer trainId) {
		TrainAllResponseDTO trainAllDetails = trainService.getTrainAllDetails(trainId);
		//System.out.println("jgvhblkjbkjhkn"+trainAllDetails.getResponseDTO());
		return new ResponseEntity<TrainAllResponseDTO>(trainAllDetails, HttpStatus.OK);
	}
	
	@GetMapping("/train/trip/{tripId}/route")
	public RouteDto getRoute(@PathVariable("tripId") Integer tripId) {
		return trainService.getRoute(tripId);
	}
	
}
