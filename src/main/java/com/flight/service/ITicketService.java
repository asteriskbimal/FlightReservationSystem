package com.flight.service;

import org.springframework.stereotype.Service;

import com.flight.model.Ticket;

@Service
public interface ITicketService {
	public void saveTicket(Ticket ticket);
}
