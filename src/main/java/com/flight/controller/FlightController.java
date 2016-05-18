package com.flight.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.flight.model.Flight;
import com.flight.model.Person;
import com.flight.model.Ticket;
import com.flight.service.FlightService;
import com.flight.service.ITicketService;
import com.flight.service.PersonService;

//validation
import org.springframework.validation.BindingResult;


@Controller
@Scope("session")
//@SessionAttributes(value= {"flightData","newFlight"})
public class FlightController {
	
	@Autowired
	private FlightService flightservice;
	
	@Autowired
	private ITicketService ticketService;
	@Autowired
	private PersonService passengerService;

	@RequestMapping("/flight")
	public String redirectRoot(Model m) {
		//m.addAttribute("flight3", new Flight());
		 m.addAttribute(new Flight()); 
		return "flight";
	}
	
	@RequestMapping(value = "/flightSearch", method = RequestMethod.POST)
	public String searchFlights(HttpServletRequest request, Model model) throws ParseException {

		String from = request.getParameter("from");
		String to = request.getParameter("to");
		Date departureDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("departureDate"));
		//Date departureTime = new SimpleDateFormat("HH:mm").parse(request.getParameter("departureTime"));
		List<Flight> listflights=flightservice.getCustomFlightList(from, to, departureDate);
		System.out.println(listflights.get(0).getFlightId());
		model.addAttribute("listflights",listflights);
		return "flightList";
	}

	@RequestMapping(value = "/addFlight", method = RequestMethod.POST)
	public String getAll(HttpServletRequest request, Model model) throws ParseException {

		String flightCode = request.getParameter("flightCode");
		String from = request.getParameter("fromLocation");
		String to = request.getParameter("toLocation");
		String flightStatus = request.getParameter("flightStatus");
		int availSeats = Integer.valueOf(request.getParameter("availSeats"));
		long price = (long) Long.parseLong(request.getParameter("price"));
		
		System.out.println("i was here");
		Date departureDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("departureDate"));
		Date arrivalDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("arrivalDate"));
		Date departureTime = new SimpleDateFormat("HH:mm").parse(request.getParameter("departureTime"));
		Date arrivalTime = new SimpleDateFormat("HH:mm").parse(request.getParameter("arrivalTime"));
//		flight.setArrivalDate(arrivalDate);
//		flight.setArrivalTime(arrivalTime);
//		flight.setDepartureDate(departureDate);
//		flight.setDepartureTime(departureTime);
		flightservice.saveFlight(new Flight(flightStatus,price,flightCode,from,to,departureDate,arrivalDate,departureTime,arrivalTime, availSeats));
		//flightservice.saveFlight(flight);
		return "redirect:/listFlight";
	}

	@RequestMapping(value = "/listFlight", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("listflights", flightservice.getAllFlight());
		return "flightList";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String get(@PathVariable long id, Model model) {
		model.addAttribute("flight", flightservice.getOneFlight(id));
		return "updateFlight";
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public String book(@PathVariable long id, Model model) {
		Flight f = flightservice.getOneFlight(id);

		model.addAttribute("flightData", f);

		return "paymentgateway";
	}

	@RequestMapping(value = "/details/paymentgateway", method = RequestMethod.POST)
	public String payment(@ModelAttribute("flightData") @Valid Flight flight,BindingResult result,HttpServletRequest request,HttpSession session,Model model) {
 
		if(result.hasErrors()) {
			return "BookingConfirmation";
		}
//		SystemUser user = userService.getOneUser((long)1);
 		//Passenger passanger = new Passanger()
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName(); //get logged in username
	     System.out.println(name);
		Person p = passengerService.getPersonWithUsername(name);
	    ticketService.saveTicket(new Ticket("new", flight.getFromLocation() + "to" + flight.getToLocation(), 
	    		"flexible", flight.getPrice(), flight, p));
	    System.out.println(ticketService);
	    //decrement available seat for the flight
	    int x =flight.getAvailSeats()-1;
	    flight.setAvailSeats(x);
	    
	    
		//confirm booking
		//send email
		
		System.out.println(request.getParameter("departureDate"));
		System.out.println(request.getParameter("flightCode"));
		return "home";
	}

	@RequestMapping(value = "/editFlight", method = RequestMethod.POST)
	public String update(@ModelAttribute("flight") Flight flight,Model model) {
		flightservice.updateFlight(flight);
		return "redirect:/listFlight";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(long id) {
		this.flightservice.deleteFlight(id);
		return "redirect:/listFlight";
	}

	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("/jsp/404");
		return mv;
	}

}