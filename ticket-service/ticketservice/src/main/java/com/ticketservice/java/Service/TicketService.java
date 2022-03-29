package com.ticketservice.java.Service;

import javax.validation.Valid;

import com.ticketservice.java.Controller.TicketListDTO;
import com.ticketservice.java.Dto.TripToBookDTO;

public interface TicketService {

	Integer saveTicket(@Valid TripToBookDTO tripToBook);

	TicketListDTO getTicketsByUser(Integer userId, Integer pageNo, Integer pageSize);

}
