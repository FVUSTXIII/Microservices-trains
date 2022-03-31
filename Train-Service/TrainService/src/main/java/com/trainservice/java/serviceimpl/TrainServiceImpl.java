package com.trainservice.java.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trainservice.java.dto.ResponseDTO;
import com.trainservice.java.dto.RouteDto;
import com.trainservice.java.dto.TrainAllDetails;
import com.trainservice.java.dto.TrainAllResponseDTO;
import com.trainservice.java.dto.TrainDetails;
import com.trainservice.java.dto.TrainResponseDTO;
import com.trainservice.java.dto.TripDetails;
import com.trainservice.java.dto.TripRequestDTO;
import com.trainservice.java.dto.TripResponseDTO;
import com.trainservice.java.entity.Route;
import com.trainservice.java.entity.Train;
import com.trainservice.java.entity.Trips;
import com.trainservice.java.exception.RouteNotFoundException;
import com.trainservice.java.exception.TrainEmptyException;
import com.trainservice.java.exception.TrainListEmptyException;
import com.trainservice.java.exception.TripsNotFoundException;
import com.trainservice.java.repository.RouteRepository;
import com.trainservice.java.repository.TrainRepository;
import com.trainservice.java.repository.TripRepository;
import com.trainservice.java.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService{
	
	@Autowired
	TripRepository tripRepository;
	
	
	@Autowired
	RouteRepository routeRepository;
	
	@Autowired
	TrainRepository trainRepository;

	@Override
	public TrainResponseDTO getAllTrainsDetails(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Train> trainPage = trainRepository.findAll(paging);
		List<Train> trainList = trainPage.getContent();
		//Exception 
		if (trainList.isEmpty()) {
			throw new TrainListEmptyException("There are no trains at the moment, please try again later");	
		}
		
		List<TrainDetails> trainDetailsList = trainList.stream()
				.map(train -> {
						TrainDetails trainDetail = new TrainDetails();
						BeanUtils.copyProperties(train, trainDetail);
						return trainDetail;
					}).collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Train Details Fetch Success", 200);
		TrainResponseDTO trainResponseDto = new TrainResponseDTO();
		trainResponseDto.setTrainList(trainDetailsList);
		trainResponseDto.setResponseDTO(responseDTO);
		return trainResponseDto;
	}

	@Override
	public TrainAllResponseDTO getTrainAllDetails(Integer trainId) {
		Optional<Train> train = trainRepository.findById(trainId);
		if (train.isEmpty()) {
			throw new TrainEmptyException("There are no trains for the ID="+trainId);	
		}
		
		TrainAllDetails trainAllDetails = new TrainAllDetails();
		trainAllDetails.setTrainName(train.get().getTrainName());
		trainAllDetails.setCapacity(train.get().getCapacity());
		trainAllDetails.setTrainScore(train.get().getTrainScore());
		trainAllDetails.setTrainType(train.get().getTrainType());
		ResponseDTO responseDTO = new ResponseDTO("Train Information Fetched Successfully", 200);
		TrainAllResponseDTO trainAllResponseDTO = new TrainAllResponseDTO();
		trainAllResponseDTO.setTrainAllDetails(trainAllDetails);
		trainAllResponseDTO.setResponseDTO(responseDTO);
		return trainAllResponseDTO;
	}
	

	@Override
	public TripResponseDTO getTripsDetails(TripRequestDTO tripRequestDTO, Integer pageNo, Integer pageSize) {

		Pageable paging = PageRequest.of(pageNo, pageSize);
		Route routes =  routeRepository.findBySourceAndDestination(tripRequestDTO.getSource(), tripRequestDTO.getDestination());


		if(routes == null)
		{
			throw new RouteNotFoundException("We can not found any route with the given source: "+tripRequestDTO.getSource()+" and destination: "+tripRequestDTO.getDestination());
		}

		Page<Trips> tripsList = tripRepository.findByTripDateAndRouteId(tripRequestDTO.getDate(), routes.getRouteId(),paging);
		List<Trips> tripsFinalList = tripsList.getContent();

		if(tripsList.isEmpty())
		{
			throw new TripsNotFoundException("We can not found any trip with the given source:"+tripRequestDTO.getSource()+" and destination: "
												+tripRequestDTO.getDestination()+" in the given date: "+tripRequestDTO.getDate()+" try another date!");
		}

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

	@Override
	public RouteDto getRouteByTripId(Integer tripId) {
		// TODO Auto-generated method stub
		Optional<Trips> trip = tripRepository.findById(tripId);
		System.out.println("Llegamos y tenemos : " + trip);
		if (trip.isEmpty()) {
			throw new TripsNotFoundException("Trip with ID: " + tripId + " not found");
		}
		RouteDto route = routeRepository.findByRouteId(trip.get().getRouteId());
		return route;
	}

	@Override
	public String getConnectivityConfirmation() {
		// TODO Auto-generated method stub
		return "Connection Successful";
	}

	
	
	

	

}
