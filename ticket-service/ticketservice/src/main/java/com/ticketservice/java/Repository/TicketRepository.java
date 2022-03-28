package com.ticketservice.java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketservice.java.Entity.Ticket;



@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	
}
