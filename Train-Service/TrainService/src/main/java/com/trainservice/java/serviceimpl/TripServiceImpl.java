package com.trainservice.java.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainservice.java.dto.TripDto;
import com.trainservice.java.entity.Trips;
import com.trainservice.java.repository.RouteRepository;
import com.trainservice.java.repository.TrainRepository;
import com.trainservice.java.repository.TripRepository;
import com.trainservice.java.service.TripService;

@Service
public class TripServiceImpl implements TripService{
	@Autowired
	TripRepository tripRepository;

	@Autowired
	TrainRepository trainRepository;
	
	@Autowired
	RouteRepository routeRepository;
	
	@Override
	public TripDto getTripById(Integer tripId) {
		TripDto tripDto = new TripDto();
		Optional<Trips> trip = Optional.of(tripRepository.findByTripId(tripId));
		tripDto.setTrainId(trip.get().getTrainId());
		tripDto.setRouteId(trip.get().getRouteId());
		Double route_price = routeRepository.findByRouteId(trip.get().getRouteId()).getRouteCost();
		Double train_fair = trainRepository.findById(trip.get().getTrainId()).get().getTrainType();
		tripDto.setTripCost(route_price * train_fair);
		tripDto.setTripDate(trip.get().getTripDate());
		return tripDto;
	}

}
