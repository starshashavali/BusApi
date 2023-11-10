package com.org.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.org.dto.PassengerRequest;
import com.org.dto.TicketRequest;
import com.org.exception.IdNotFoundException;
import com.org.service.impl.IBusServiceImpl;

@SpringBootTest
public class TestIBusServiceImpl {

	@InjectMocks
	private IBusServiceImpl iBusService;
	
	@Mock
    private Map<Integer, TicketRequest> ticketMap;

	@Test
	void testBookTicket() {
		PassengerRequest passengerRequest = new PassengerRequest("shasha", "ATP", "Blr", 3, 799.9);
		TicketRequest ticketRequest = iBusService.bookTicket(passengerRequest);
		assertEquals("Successfully booked", ticketRequest.getTicketStatus());
	}



	@Test
	void testIdNotFoundException() {
		IdNotFoundException ex = assertThrows(IdNotFoundException.class, () -> {
			iBusService.getTicketById(33);
		});
		assertEquals("Id not found ::" + 33, ex.getMessage());
	}


    @Test
    void testGetAllBookedTickets() {
        TicketRequest ticket1 = new TicketRequest(1, "Shankar", "ATP", "Kdr", 3, "success", 899.9);
        TicketRequest ticket2 = new TicketRequest(2, "Siva", "ATP", "Kdr", 3, "success", 899.9);

        Map<Integer, TicketRequest> mockTicketMap = new HashMap<>();
        mockTicketMap.put(ticket1.getTicketNumber(), ticket1);
        mockTicketMap.put(ticket2.getTicketNumber(), ticket2);

        when(ticketMap.values()).thenReturn(mockTicketMap.values());

        List<TicketRequest> allBookedTickets = iBusService.getAllBookedTickets();

        assertEquals(2, allBookedTickets.size());
       
    }

    @Test
    void testGetTicketById_ExistingId() {
        int existingTicketId = 1;
        TicketRequest expectedTicket = new TicketRequest(existingTicketId, "John Doe", "ATP", "Kdr", 3, "success", 899.9);

        when(ticketMap.containsKey(existingTicketId)).thenReturn(true);
        when(ticketMap.get(existingTicketId)).thenReturn(expectedTicket);

        TicketRequest retrievedTicket = iBusService.getTicketById(existingTicketId);

        assertEquals(expectedTicket, retrievedTicket);     }


}
