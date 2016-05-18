package com.flight.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flight.model.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long>{

}
