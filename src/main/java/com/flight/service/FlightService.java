package com.flight.service;

import java.util.Date;
import java.util.List;
import com.flight.model.Flight;

public interface FlightService {
	public void saveFlight(Flight flight);
	public void deleteFlight(Long id);
	public List<Flight> getAllFlight();
	public Flight getOneFlight(Long id);
	public void updateFlight(Flight flight);
	public List<Flight> getCustomFlightList(String from,String to,Date departureDate);

}
