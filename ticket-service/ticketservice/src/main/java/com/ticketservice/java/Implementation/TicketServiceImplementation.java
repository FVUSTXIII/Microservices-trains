package com.ticketservice.java.Implementation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketservice.java.Client.TrainClient;
import com.ticketservice.java.Client.UserClient;
import com.ticketservice.java.Dto.TripToBookDTO;
import com.ticketservice.java.Entity.Ticket;
import com.ticketservice.java.Repository.TicketRepository;
import com.ticketservice.java.Service.TicketService;
@Service
public class TicketServiceImplementation implements TicketService{
	@Autowired
	UserClient userClient;
	
	/*@Autowired
	TrainClient trainClient;*/
	
	@Autowired
	TicketRepository ticketRepo;

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
}
