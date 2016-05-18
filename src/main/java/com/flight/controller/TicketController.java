package com.flight.controller;

import java.util.ArrayList;

//import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flight.model.Flight;
import com.flight.model.Person;
import com.flight.model.Ticket;
import com.flight.service.FlightService;
import com.flight.service.IMailSenderService;
import com.flight.service.PersonService;

@Controller
@Scope("session")
public class TicketController {
	private PersonService passengerService;
	private IMailSenderService mailSenderService;
	private FlightService flightService;

	@Autowired
	public TicketController(PersonService passengerService, FlightService flightService, IMailSenderService mailSenderService) {
		this.flightService = flightService;
		this.passengerService = passengerService;
		this.mailSenderService=mailSenderService;
	}
	
	
	@RequestMapping(value="/ticket", method=RequestMethod.GET)
	public String ticketPageShow(Model m){
		
		/*List<Flight> flight = flightService.getByFlightNumber();
		m.addAttribute("flight",flight);*/
		return "ticket";
	}
	
	@RequestMapping(value="/ticket", method = RequestMethod.POST)
    public String processeConformation(Model m) {
        try{ 
		mailSenderService.sendMail("nwlf53@gmail.com", "Conformation", "This mail is just for conformation.");     
        }
        catch(Exception ex){
        	String error=ex.getMessage();
        	m.addAttribute("errorMessage",error);
        	System.out.println(error);
        }
        finally {
			return "index";
		}       
    }

	

}
