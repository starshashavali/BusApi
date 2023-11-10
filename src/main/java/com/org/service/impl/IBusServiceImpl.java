package com.org.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.org.dto.PassengerRequest;
import com.org.dto.TicketRequest;
import com.org.exception.IdNotFoundException;
import com.org.service.IBusService;

@Service
public class IBusServiceImpl implements IBusService {

	private Map<Integer, TicketRequest> ticketMap = new HashMap<>();

	private Integer ticketNum = 1;

	@Override
	public TicketRequest bookTicket(PassengerRequest request) {
		TicketRequest ticket = new TicketRequest();
		BeanUtils.copyProperties(request, ticket);
		ticket.setTicketNumber(ticketNum);
		ticket.setTicketStatus("Successfully booked");
		ticket.setPrice(request.getPrice() * request.getPassengesCount());
		ticketMap.put(ticketNum, ticket);
		ticketNum++;
		return ticket;
	}

	@Override
	public TicketRequest getTicketById(Integer ticketNum) {
		if (ticketMap.containsKey(ticketNum)) {
			return ticketMap.get(ticketNum);
		}
		throw new IdNotFoundException("Id not found ::" + ticketNum);
	}

	@Override
	public List<TicketRequest> getAllBookedTickets() {
	return ticketMap.values().stream().collect(Collectors.toList());
	}

	

}
