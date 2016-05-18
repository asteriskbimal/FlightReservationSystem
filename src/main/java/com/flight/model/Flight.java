package com.flight.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;

//validation



@Entity
public class Flight {
	
	public Flight(){
		
	}
	public Flight(String flightStatus,long price,String flightCode, String fromLocation,String toLocation,Date departureDate,Date arrivalDate,Date departureTime,Date arrivalTime,int availSeats){
		this.flightCode =flightCode;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.availSeats = availSeats;
		this.price=price;
		this.flightStatus=flightStatus;
		
	}

	@Id @GeneratedValue
	private long flightId;
	
	private String flightCode;
	
	private String flightStatus;
	
	public String getFlightStatus() {
		return flightStatus;
	}
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}

	private String fromLocation;
	
	private String toLocation;
	//@Future(message="Departure date should be in the future")
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	//@Future(message="Arrival date should be in the future")
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;
	@Temporal(TemporalType.TIME)
	private Date departureTime;
	@Temporal(TemporalType.TIME)
	private Date arrivalTime;

	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	private double price;
	
	@Min(0)
	private int availSeats;
	
	@OneToMany(mappedBy="flight",cascade=CascadeType.ALL)
	private List<Ticket> tickets=new ArrayList<Ticket>();

	public long getFlightId() {
		return flightId;
	}
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}
	public String getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public int getAvailSeats() {
		return availSeats;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setAvailSeats(int availSeats) {
		this.availSeats = availSeats;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	
}
