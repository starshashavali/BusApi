package com.org.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.dto.PassengerRequest;
import com.org.dto.TicketRequest;
import com.org.service.IBusService;

@RestController
public class BusRestController {
	@Autowired
	private IBusService service;

	@PostMapping("/book")
	public ResponseEntity<?> bookBusTicket(@RequestBody PassengerRequest request) {
		TicketRequest ticket = service.bookTicket(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
	}

	@GetMapping("/bustapi/{ticketNum}")
	public ResponseEntity<?> getBusTicket(@PathVariable Integer ticketNum) {
		TicketRequest id = service.getTicketById(ticketNum);
		return ResponseEntity.status(HttpStatus.OK).body(id);

	}

	@GetMapping("/getAllTicket")
	public ResponseEntity<List<TicketRequest>> getAllTickets() {
		List<TicketRequest> tickets = service.getAllBookedTickets();
		return ResponseEntity.status(HttpStatus.OK).body(tickets);
	}

}
