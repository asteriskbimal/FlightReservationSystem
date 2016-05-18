package com.flight.serviceimpl;

import org.springframework.stereotype.Service;

import com.flight.model.Ticket;
import com.flight.repository.ITicketRepository;
import com.flight.service.ITicketService;

@Service
public class TicketServiceImpl implements ITicketService {
	private ITicketRepository ticketrepo;

	public void saveTicket(Ticket ticket) {
		
		 ticketrepo.save(ticket);
	}

}
