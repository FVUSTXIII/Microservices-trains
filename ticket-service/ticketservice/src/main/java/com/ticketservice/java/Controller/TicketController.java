package com.ticketservice.java.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketservice.java.Client.TrainClient;
import com.ticketservice.java.Client.UserClient;
import com.ticketservice.java.Dto.TripToBookDTO;
import com.ticketservice.java.Dto.ResponseDTO;
import com.ticketservice.java.Dto.TripBookedResponseDTO;
import com.ticketservice.java.Implementation.TicketServiceImplementation;
import com.ticketservice.java.Service.TicketService;

@RestController
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/tickets/book")
	public ResponseEntity<TripBookedResponseDTO> bookTrip(@Valid @RequestBody TripToBookDTO tripToBook) {
		Integer ticketId = ticketService.saveTicket(tripToBook);
		TripBookedResponseDTO response = new TripBookedResponseDTO();
		response.setTicketId(ticketId);
		ResponseDTO temp_response = new ResponseDTO("Trip Booked Successfully", 200);
		response.setResponseDTO(temp_response);
		return new ResponseEntity<TripBookedResponseDTO>(response, HttpStatus.ACCEPTED);
	}
	/*
	@GetMapping("/users/{userId}/tickets")
	public*/ 
	
}
