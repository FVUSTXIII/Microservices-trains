package com.ticketservice.java.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketservice.java.Client.TrainClient;
import com.ticketservice.java.Client.UserClient;
import com.ticketservice.java.Dto.TripToBookDTO;
import com.ticketservice.java.Dto.ResponseDTO;
import com.ticketservice.java.Dto.TripBookedResponseDTO;
import com.ticketservice.java.Implementation.TicketServiceImplementation;
import com.ticketservice.java.Service.TicketService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/tickets/book")
	@CircuitBreaker(fallbackMethod = "serviceUnavailable", name = "TRAINSERVICE")
	public ResponseEntity<TripBookedResponseDTO> bookTrip(@Valid @RequestBody TripToBookDTO tripToBook) {
		Integer ticketId = ticketService.saveTicket(tripToBook);
		TripBookedResponseDTO response = new TripBookedResponseDTO();
		response.setTicketId(ticketId);
		ResponseDTO temp_response = new ResponseDTO("Trip Booked Successfully", 200);
		response.setResponseDTO(temp_response);
		return new ResponseEntity<TripBookedResponseDTO>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/users/{userId}/tickets")
	@CircuitBreaker(fallbackMethod = "serviceUnavailable", name = "TRAINSERVICE")
	public ResponseEntity<TicketListDTO> getTicketsByUser(
			@RequestParam(defaultValue = "0")Integer pageNo,
			@RequestParam(defaultValue = "5")Integer pageSize,
			@PathVariable("userId") Integer userId) {
		TicketListDTO ticketlistDTO = ticketService.getTicketsByUser(userId, pageNo, pageSize);
		return new ResponseEntity<TicketListDTO>(ticketlistDTO, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<String> serviceUnavailable(Exception e) {
		return new ResponseEntity<String>("Service unavailable 503!!!", HttpStatus.OK);
	}
	
	
}
