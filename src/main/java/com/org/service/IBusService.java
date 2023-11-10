package com.org.service;

import java.util.List;

import com.org.dto.PassengerRequest;
import com.org.dto.TicketRequest;

public interface IBusService {

	public TicketRequest bookTicket(PassengerRequest request);

	public TicketRequest getTicketById(Integer ticketId);

	public List<TicketRequest> getAllBookedTickets();

}
