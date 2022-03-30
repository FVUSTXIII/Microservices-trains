package com.mocktrainservice.java.service.implementation;

<<<<<<< HEAD
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
>>>>>>> origin/user-service
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
<<<<<<< HEAD

import com.mocktrainservice.java.dto.TripRequestDTO;
import com.mocktrainservice.java.entity.Route;
import com.mocktrainservice.java.entity.Train;
import com.mocktrainservice.java.entity.Trips;
=======
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.mocktrainservice.java.dto.TripRequestDTO;
import com.mocktrainservice.java.dto.TripResponseDTO;
import com.mocktrainservice.java.entity.Route;
import com.mocktrainservice.java.entity.Train;
import com.mocktrainservice.java.entity.Trips;
import com.mocktrainservice.java.exception.RouteNotFoundException;
import com.mocktrainservice.java.exception.TripsNotFoundException;
>>>>>>> origin/user-service
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
<<<<<<< HEAD
=======
	TripRequestDTO tripRequestDTO4;
	
	TripResponseDTO tripResponseDTO;
>>>>>>> origin/user-service
	
	Validator validator;
	
	Train train;
	Train train2;
	Train train3;
<<<<<<< HEAD
	Train train4;
	
	Route route;
	Route route2;
	Route route3;
	Route route4;
=======
	Optional<Train> trainOp1;
	Optional<Train> trainOp2;
	Optional<Train> trainOp3;
	
	Route route;
	Optional<Route> route2;
>>>>>>> origin/user-service
	
	Trips trip;
	Trips trip2;
	Trips trip3;
<<<<<<< HEAD
	Trips trip4;
	Trips trip5;
=======
	
	List<Trips> tripsList;
	List<Trips> emptyList;
	
	Page<Trips> pageList;
	Page<Trips> emptyPage;
	
	Pageable paging;
>>>>>>> origin/user-service
	
	@BeforeEach
	public void setUp()
	{
<<<<<<< HEAD
		
	}

	
=======
		//Positive case
		tripRequestDTO = new TripRequestDTO();
		tripRequestDTO.setSource("Ciudad Guzman");
		tripRequestDTO.setDestination("Guadalajara");
		tripRequestDTO.setDate(LocalDate.parse("2022-03-28"));
		
		//Negative Case (No route with given source and destination)
		tripRequestDTO2 = new TripRequestDTO();
		tripRequestDTO2.setSource("Manzanillo");
		tripRequestDTO2.setDestination("Ciudad Guzman");
		tripRequestDTO2.setDate(LocalDate.parse("2022-03-28"));
		
		//Negative Case (No trip with given date)
		tripRequestDTO3 = new TripRequestDTO();
		tripRequestDTO3.setSource("Ciudad Guzman");
		tripRequestDTO3.setDestination("Guadalajara");
		tripRequestDTO3.setDate(LocalDate.parse("2022-04-13"));
		
		//Validation Case (No data on the DTO)
		tripRequestDTO4 = new TripRequestDTO();
		tripRequestDTO4.setSource("");
		tripRequestDTO4.setDestination("");
		tripRequestDTO4.setDate(LocalDate.parse("2022-04-13"));
		
		train = new Train();
		train.setTrainId(1);
		train.setCapacity(500);
		train.setTrainName("El Tacoriendo");
		train.setTrainScore(4.3);
		train.setTrainType(1.2);
		
		train2 = new Train();
		train2.setTrainId(2);
		train2.setCapacity(300);
		train2.setTrainName("El Mostacho");
		train2.setTrainScore(4.8);
		train2.setTrainType(2.0);
		
		train3 = new Train();
		train3.setTrainId(3);
		train3.setCapacity(400);
		train3.setTrainName("El Gavilan");
		train3.setTrainScore(4.5);
		train3.setTrainType(1.5);
		
		route = new Route();
		route.setRouteId(1);
		route.setSource("Ciudad Guzman");
		route.setDestination("Guadalajara");
		route.setRouteCost(500.0);
		
		route2 = Optional.of(route);
		
		trainOp1 = Optional.of(train);
		trainOp2 = Optional.of(train2);
		trainOp3 = Optional.of(train3);
		
		trip = new Trips();
		trip.setTripId(1);
		trip.setRouteId(1);
		trip.setTrainId(1);
		trip.setTripCost(route.getRouteCost()*train.getTrainType());
		trip.setTripDate(LocalDate.parse("2022-03-28"));
		
		trip2 = new Trips();
		trip2.setTripId(2);
		trip2.setRouteId(1);
		trip2.setTrainId(2);
		trip2.setTripCost(route.getRouteCost()*train2.getTrainType());
		trip2.setTripDate(LocalDate.parse("2022-03-28"));
		
		trip3 = new Trips();
		trip3.setTripId(3);
		trip3.setRouteId(1);
		trip3.setTrainId(3);
		trip3.setTripCost(route.getRouteCost()*train3.getTrainType());
		trip3.setTripDate(LocalDate.parse("2022-03-28"));
		
		tripsList = new ArrayList<>();
		tripsList.add(trip);
		tripsList.add(trip2);
		tripsList.add(trip3);
		
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        
        paging = PageRequest.of(0,5);
        
        pageList = new PageImpl<Trips>(tripsList, paging, tripsList.size());
        
        emptyList = new ArrayList<>();
        emptyPage = new PageImpl<Trips>(emptyList, paging, emptyList.size());
	}

	
	@Test
	@DisplayName("Positive use case")
	public void getTripsDetailsTest()
	{
		when(routeRepository.findBySourceAndDestination("Ciudad Guzman", "Guadalajara")).thenReturn(route);
		when(tripRepository.findByTripDateAndRouteId(LocalDate.parse("2022-03-28"),1,paging)).thenReturn(pageList);
		when(routeRepository.findById(1)).thenReturn(route2);
		when(trainRepository.findById(1)).thenReturn(trainOp1);
		when(trainRepository.findById(2)).thenReturn(trainOp2);
		when(trainRepository.findById(3)).thenReturn(trainOp3);
		
		TripResponseDTO tripResponseDTO = trainServiceImpl.getTripsDetails(tripRequestDTO, 0, 5);
		
		assertNotNull(tripResponseDTO);
		assertEquals(1, tripResponseDTO.getTripDetails().get(0).getTripId());
		assertEquals("Ciudad Guzman", tripResponseDTO.getTripDetails().get(0).getSource());
		assertEquals("Guadalajara", tripResponseDTO.getTripDetails().get(0).getDestination());
		assertEquals("El Tacoriendo", tripResponseDTO.getTripDetails().get(0).getTrainName());
		assertEquals("Ciudad Guzman", tripResponseDTO.getTripDetails().get(0).getSource());
		assertEquals("Guadalajara", tripResponseDTO.getTripDetails().get(0).getDestination());
		assertEquals(LocalDate.parse("2022-03-28"), tripResponseDTO.getTripDetails().get(0).getTripDate());
		assertEquals(600.0, tripResponseDTO.getTripDetails().get(0).getTripCost());
		assertEquals("Trips for the given source, destination and date, Fetch Success", tripResponseDTO.getResponseDTO().getMessage());
		assertEquals(200,tripResponseDTO.getResponseDTO().getStatusCode());
		
	}
	
	@Test
	@DisplayName("Trips negative case 1: No route")
	public void getTripsDetailsTest1()
	{
		when(routeRepository.findBySourceAndDestination("Manzanillo", "Ciudad Guzman")).thenReturn(null);
		
		assertThrows(RouteNotFoundException.class, () -> trainServiceImpl.getTripsDetails(tripRequestDTO2, 0, 5));
	}
	
	@Test
	@DisplayName("Trips negative case 2: No trip with given date")
	public void getTripsDetailsTest2()
	{
		when(routeRepository.findBySourceAndDestination("Ciudad Guzman", "Guadalajara")).thenReturn(route);
		when(tripRepository.findByTripDateAndRouteId(LocalDate.parse("2022-04-13"), 1, paging)).thenReturn(emptyPage);
		
		assertThrows(TripsNotFoundException.class, () -> trainServiceImpl.getTripsDetails(tripRequestDTO3, 0, 5));
	}
	
	
	
	@Test
	@DisplayName("Trip negative case 3: request empty arguments")
	public void getTripsDetailsTest4()
	{
		
		 Set<ConstraintViolation<TripRequestDTO>> validations = validator.validate(tripRequestDTO4);
		 assertFalse(validations.isEmpty());
	}
	
>>>>>>> origin/user-service
}
