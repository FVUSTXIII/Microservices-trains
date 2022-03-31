package com.ticketservice.java.Implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import com.ticketservice.java.Client.TrainClient;
import com.ticketservice.java.Client.UserClient;
import com.ticketservice.java.Dto.RouteDTO;
import com.ticketservice.java.Dto.TripToBookDTO;
import com.ticketservice.java.Entity.Ticket;
import com.ticketservice.java.Repository.TicketRepository;



@ExtendWith(MockitoExtension.class)
public class TicketServiceImplementationTest {
	
	@Mock
	TrainClient trainClient;
	
	@Mock
	UserClient userClient;
	
	@Mock
	TicketRepository ticketRepo;
	
	@InjectMocks
	TicketServiceImplementation ticketServiceImplementation;
	
	Ticket ticket;

	RouteDTO route;
	TripToBookDTO tripToBook1;
	Validator validator;
	
	@BeforeEach
	public void setUp()	{
		ticket = new Ticket();
		ticket.setTripId(2);
		ticket.setTicketId(1);
		ticket.setUserId(5);
		ticket.setDate();
		route = new RouteDTO();
		route.setDestination("Destination 1");
		route.setSource("Source 1");
		route.setRouteCost(0.00);
		
		tripToBook1 = new TripToBookDTO();
		tripToBook1.setTripId(0);
		tripToBook1.setUserId(0);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
	
	@Test
	@DisplayName("Positive test: Save ticket")
	public void saveTest() {
		TripToBookDTO tripToBook = new TripToBookDTO();
		tripToBook.setUserId(5);
		tripToBook.setTripId(2);
		when(userClient.verify(tripToBook.getUserId())).thenReturn("User Found");
		when(trainClient.getRouteByTripId(2)).thenReturn(route);
		when(ticketRepo.save(any(Ticket.class))).thenReturn(ticket);
		Integer a = ticketServiceImplementation.saveTicket(tripToBook);
		assertEquals(5, ticket.getUserId());
		assertEquals(1, ticket.getTicketId());
		assertEquals(2, ticket.getTripId());
	}
	
	@Test
	@DisplayName("Negative test: invalid ticket form")
	public void bookTicketTest() {
		Set<ConstraintViolation<TripToBookDTO>> validations = validator.validate(tripToBook1);
		assertFalse(validations.isEmpty());
	}
	
}


