package com.mocktrainservice.java.service.implementation;

import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mocktrainservice.java.dto.TripRequestDTO;
import com.mocktrainservice.java.entity.Route;
import com.mocktrainservice.java.entity.Train;
import com.mocktrainservice.java.entity.Trips;
import com.mocktrainservice.java.repository.RouteRepository;
import com.mocktrainservice.java.repository.TrainRepository;
import com.mocktrainservice.java.repository.TripRepository;
import com.mocktrainservice.java.serviceimpl.TrainServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TrainServiceImplTest {

	@Mock
	RouteRepository routeRepository;
	
	@Mock
	TrainRepository trainRepository;
	
	@Mock
	TripRepository tripRepository;
	
	@InjectMocks
	TrainServiceImpl trainServiceImpl;
	
	TripRequestDTO tripRequestDTO;
	TripRequestDTO tripRequestDTO2;
	TripRequestDTO tripRequestDTO3;
	
	Validator validator;
	
	Train train;
	Train train2;
	Train train3;
	Train train4;
	
	Route route;
	Route route2;
	Route route3;
	Route route4;
	
	Trips trip;
	Trips trip2;
	Trips trip3;
	Trips trip4;
	Trips trip5;
	
	@BeforeEach
	public void setUp()
	{
		
	}

	
}
