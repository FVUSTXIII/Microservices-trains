package com.ticketservice.java.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketservice.java.Client.TrainClient;
import com.ticketservice.java.Client.UserClient;
import com.ticketservice.java.Service.TicketService;
@Service
public class TicketServiceImplementation implements TicketService{
	@Autowired
	UserClient userClient;
	
	@Autowired
	TrainClient trainClient;
}
