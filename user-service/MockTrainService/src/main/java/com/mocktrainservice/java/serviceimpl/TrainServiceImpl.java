package com.mocktrainservice.java.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mocktrainservice.java.dto.ResponseDTO;
import com.mocktrainservice.java.dto.TripDetails;
import com.mocktrainservice.java.dto.TripRequestDTO;
import com.mocktrainservice.java.dto.TripResponseDTO;
import com.mocktrainservice.java.entity.Route;
import com.mocktrainservice.java.entity.Trips;
import com.mocktrainservice.java.exception.RouteNotFoundException;
import com.mocktrainservice.java.exception.TripsNotFoundException;
import com.mocktrainservice.java.repository.RouteRepository;
import com.mocktrainservice.java.repository.TrainRepository;
import com.mocktrainservice.java.repository.TripRepository;
import com.mocktrainservice.java.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	TripRepository tripRepository;
	
	@Autowired
	TrainRepository trainRepository;
	
	@Autowired
	RouteRepository routeRepository;
	
	@Override
	public TripResponseDTO getTripsDetails(TripRequestDTO tripRequestDTO, Integer pageNo, Integer pageSize) {
		
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Route routes =  routeRepository.findBySourceAndDestination(tripRequestDTO.getSource(), tripRequestDTO.getDestination());


		if(routes == null)
		{
			throw new RouteNotFoundException("We can not found any route with the given source: "+tripRequestDTO.getSource()+" and destination: "+tripRequestDTO.getDestination());
		}

		List<Trips> tripsList = tripRepository.findByTripDateAndRouteId(tripRequestDTO.getDate(), routes.getRouteId());

		if(tripsList.isEmpty())
		{
			throw new TripsNotFoundException("We can not found any trip with the given source:"+tripRequestDTO.getSource()+" and destination: "
												+tripRequestDTO.getDestination()+" in the given date: "+tripRequestDTO.getDate()+" try another date!");
		}
		
		Page<Trips> pageList = new PageImpl<Trips>(tripsList,paging, tripsList.size());
		List<Trips> tripsFinalList = pageList.getContent();
		List<TripDetails> tripsDetails = new ArrayList<>();
		
		for(Trips trips : tripsFinalList)
		{
			TripDetails tripDetails = new TripDetails();
			tripDetails.setTripId(trips.getTripId());
			tripDetails.setTripDate(trips.getTripDate());
			tripDetails.setRoute(routeRepository.findById(trips.getRouteId()));
			tripDetails.setSource(routeRepository.findById(trips.getRouteId()).get().getSource());
			tripDetails.setDestination(routeRepository.findById(trips.getRouteId()).get().getDestination());
			tripDetails.setTrainName(trainRepository.findById(trips.getTrainId()).get().getTrainName());
			tripDetails.setTripCost(trips.getTripCost());
			tripsDetails.add(tripDetails);
		}
		ResponseDTO responseDTO = new ResponseDTO("Trips for the given source, destination and date, Fetch Success", 200);
		TripResponseDTO tripResponseDto = new TripResponseDTO();
		tripResponseDto.setTripDetails(tripsDetails);
		tripResponseDto.setResponseDTO(responseDTO);
		return tripResponseDto;
	}

}
