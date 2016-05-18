package com.flight.repository;

import org.springframework.data.repository.CrudRepository;
import com.flight.model.Ticket;

public interface ITicketRepository extends CrudRepository<Ticket, Long>{
}
