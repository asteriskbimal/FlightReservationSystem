package com.flight.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flight.model.Flight;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long>{

	@Query("from Flight a where a.toLocation=:to and a.fromLocation=:from and  a.departureDate=:departureDate")
	public List<Flight> getCustomFlightList(@Param("from") String from,@Param("to") String to,@Param("departureDate") Date departureDate);
}
