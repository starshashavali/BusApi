package com.org.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerRequest {
	
	
	private String name;
	
	private String source;
	
	private String destination;
	
	private Integer passengesCount;
	
	private Double price;
	

}
