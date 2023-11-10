package com.org.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {
	
	private Integer ticketNumber;

	private String name;

	private String source;

	private String destination;

	private Integer passengesCount;

	private String ticketStatus;
	
	private Double price;
	
}
