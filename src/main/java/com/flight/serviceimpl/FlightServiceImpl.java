package com.flight.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.model.Flight;
import com.flight.repository.FlightRepository;
import com.flight.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepository flightrepo;

	public void saveFlight(Flight flight) {
		flightrepo.save(flight);
		
	}

	public void deleteFlight(Long id) {
		flightrepo.delete(id);
		
	}

	public List<Flight> getAllFlight() {
		
		return  (List<Flight> )flightrepo.findAll();
	}

	public Flight getOneFlight(Long id) {
		
		return (Flight)flightrepo.findOne(id);
	}

   public void updateFlight(Flight flight) {
		
		flightrepo.save(flight);
		//return true;
	}

   public List<Flight> getCustomFlightList(String from,String to,Date departureDate){
	   return (List<Flight>)flightrepo.getCustomFlightList(from, to, departureDate);
   }


}
