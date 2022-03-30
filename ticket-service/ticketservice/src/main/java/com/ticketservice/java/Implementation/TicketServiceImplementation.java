package com.ticketservice.java.Implementation;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ticketservice.java.Client.TrainClient;
import com.ticketservice.java.Client.UserClient;
import com.ticketservice.java.Controller.TicketListDTO;
import com.ticketservice.java.Dto.ResponseDTO;
import com.ticketservice.java.Dto.RouteDTO;
import com.ticketservice.java.Dto.TripDTO;
import com.ticketservice.java.Dto.TripToBookDTO;
import com.ticketservice.java.Dto.ticketDetails;
import com.ticketservice.java.Entity.Ticket;
import com.ticketservice.java.Exception.ServiceUnavailableException;
import com.ticketservice.java.Repository.TicketRepository;
import com.ticketservice.java.Service.TicketService;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
@Service
public class TicketServiceImplementation implements TicketService{
	@Autowired(required = false)
	UserClient userClient;
	
	@Autowired(required = false)
	TrainClient trainClient;
	
	@Autowired
	TicketRepository ticketRepo;
	
	@Autowired
	CircuitBreakerFactory circuitBreakerFactory;
	
	@Override
	public Integer saveTicket(@Valid TripToBookDTO tripToBook) {
		// TODO Auto-generated method stub
		Ticket ticket = new Ticket();
		ticket.setTripId(tripToBook.getTripId());
		ticket.setUserId(tripToBook.getUserId());
		ticket.setDate();
		ticketRepo.save(ticket);
		return ticket.getTicketId();
	}

	@Override
	public TicketListDTO getTicketsByUser(Integer userId, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Ticket> ticket_page =  ticketRepo.findByUserId(userId, paging);
		List<Ticket> ticket_list = ticket_page.getContent();
		TicketListDTO respose = new TicketListDTO();
		
		ticket_list.forEach(ticket -> {
			ticketDetails newDetails = new ticketDetails();
			newDetails.setTicketId(ticket.getTicketId());
			newDetails.setTripId(ticket.getTripId());
			//circuitBreaker.run(() -> trainClient.verifyConnectivity(),  throwable -> "unable to reach service");
			Optional<RouteDTO> route = Optional.of(trainClient.getRouteByTripId(ticket.getTripId()));
			newDetails.setRoute(route.get());			
			TripDTO trip = trainClient.getTripById(ticket.getTripId());
			newDetails.setTripDate(trip.getTripDate().atTime(20,50));
			newDetails.setTripCost(trip.getTripCost());
			newDetails.setTicketDate(ticket.getDate());
			respose.addToTicketList(newDetails);
		});
		respose.setResponseDTO(new ResponseDTO("Ticket list retrieved successfully", 200));
		return respose;
	}

	
	
}
