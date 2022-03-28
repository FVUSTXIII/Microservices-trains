package com.ticketservice.java.Service;

import javax.validation.Valid;

import com.ticketservice.java.Dto.TripToBookDTO;

public interface TicketService {

	Integer saveTicket(@Valid TripToBookDTO tripToBook);

}
