package com.flight.service;

import java.util.List;

import com.flight.model.Ticket;

public interface TicketService {

	public void saveTicket(Ticket Ticket);
	public void deleteTicket(Long id);
	public List<Ticket> getAllTicket();
	public Ticket getOneTicket(Long id);
}
