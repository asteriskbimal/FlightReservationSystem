package com.flight.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ticket {

	@Id	
	private long ticketId;

	private int ticketNumber;

	private String status;

	private String routing;

	private String fairType;
	
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@ManyToOne
	@JoinColumn(name = "flightId")
	private Flight flight;

	@OneToOne
	//(cascade=CascadeType.ALL)
	@JoinColumn(name = "personId")
	private Person passenger;

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRouting() {
		return routing;
	}

	public void setRouting(String routing) {
		this.routing = routing;
	}

	public String getFairType() {
		return fairType;
	}

	public void setFairType(String fairType) {
		this.fairType = fairType;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Person getPassenger() {
		return passenger;
	}

	public void setPassenger(Person passenger) {
		this.passenger = passenger;
	}

	public Ticket( String status, String routing, String fairType, double price, Flight flight,
			Person passenger) {
		super();
		//this.ticketNumber = ticketNumber;
		this.status = status;
		this.routing = routing;
		this.fairType = fairType;
		this.price = price;
		this.flight = flight;
		this.passenger = passenger;
	}
	

}
