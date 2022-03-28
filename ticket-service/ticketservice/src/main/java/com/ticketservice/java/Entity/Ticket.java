package com.ticketservice.java.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.TimeZone;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;
	private Integer userId;
	private Integer tripId;
	@Column(name="ticketDate", nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime date;
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTripId() {
		return tripId;
	}
	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate() {
		//ZoneId zone1 = ZoneId.systemDefault();
		ZoneId zone1 = ZoneId.of("Mexico/General");
		this.date = LocalDateTime.now(zone1);
	}
	
	
}
