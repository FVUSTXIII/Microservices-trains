package com.ticketservice.java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketservice.java.Client.TrainClient;
import com.ticketservice.java.Client.UserClient;
import com.ticketservice.java.Implementation.TicketServiceImplementation;
import com.ticketservice.java.Service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/tickets/book")
	
	
}
