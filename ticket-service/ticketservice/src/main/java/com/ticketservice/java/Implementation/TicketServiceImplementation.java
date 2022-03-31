package com.ticketservice.java.Implementation;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.ticketservice.java.Exception.TripsNotFoundException;
import com.ticketservice.java.Exception.UserNotFoundException;
import com.ticketservice.java.Repository.TicketRepository;
import com.ticketservice.java.Service.TicketService;



import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;

@Service
public class TicketServiceImplementation implements TicketService {
	@Autowired(required = false)
	UserClient userClient;
	
	@Autowired(required = false)
	TrainClient trainClient;
	
	@Autowired
	TicketRepository ticketRepo;
	
	@Autowired
	CircuitBreakerFactory cbf;
	
	@Override
	public Integer saveTicket(@Valid TripToBookDTO tripToBook) {
		// TODO Auto-generated method stub
		Ticket ticket = new Ticket();
		if (trainClient.getRouteByTripId(tripToBook.getTripId()).getSource() == null) {
			throw new TripsNotFoundException("The trip with ID " + tripToBook.getTripId() + " was not found");
		}
		if (userClient.verify(tripToBook.getUserId()) != "User Found") {	
			throw new UserNotFoundException("The user with ID " + tripToBook.getUserId() + " was not found");
		}
		ticket.setTripId(tripToBook.getTripId());
		ticket.setUserId(tripToBook.getUserId());
		ticket.setDate();
		ticketRepo.save(ticket);
		return ticket.getTicketId();
	}

	@Override
	public TicketListDTO getTicketsByUser(Integer userId, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		//CircuitBreaker cb = cbf.create("circuitbreaker");
		
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Ticket> ticket_page =  ticketRepo.findByUserId(userId, paging);
		List<Ticket> ticket_list = ticket_page.getContent();
		TicketListDTO respose = new TicketListDTO();
		//cb.run(() -> trainClient.verifyConnection(), throwable -> serviceUnavailable("Train"));
		ticket_list.forEach(ticket -> {
			ticketDetails newDetails = new ticketDetails();
			newDetails.setTicketId(ticket.getTicketId());
			newDetails.setTripId(ticket.getTripId());
			RouteDTO route = trainClient.getRouteByTripId(ticket.getTripId());
			if (route.getSource() == null) {
				throw new TripsNotFoundException("The trip with ID " + ticket.getTripId() + " was not found ");
			}
			newDetails.setRoute(route);	
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
