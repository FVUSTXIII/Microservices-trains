package com.ticketservice.java.Controller;

import java.util.ArrayList;
import java.util.List;

import com.ticketservice.java.Dto.ticketDetails;
import com.ticketservice.java.Dto.ResponseDTO;

public class TicketListDTO {
	private List<ticketDetails> ticketList;
	private ResponseDTO responseDTO;
	
	public TicketListDTO() {
		ticketList = new ArrayList<>();
	}
	
	public void addToTicketList(ticketDetails detals) {
		ticketList.add(detals);
	}
	
	public List<ticketDetails> getTicketList() {
		return ticketList;
	}
	public void setTicketList(List<ticketDetails> ticketList) {
		this.ticketList = ticketList;
	}
	public ResponseDTO getResponseDTO() {
		return responseDTO;
	}
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.responseDTO = responseDTO;
	}
	
	
}
