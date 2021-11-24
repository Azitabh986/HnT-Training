package com.flight.booking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Range;

import com.flight.booking.enumValue.AirportPlace;
import com.flight.booking.enumValue.MealType;

@Entity
public class TicketBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private AirportPlace fromPlace;
	private AirportPlace toPlace;
	@Range(min=1)
	private int noOfSeat;
	private MealType mealType;
	
	private UUID pnr;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private List<PassengerDetails> passengerDetails;
	
	public void addPassenger(PassengerDetails pd) {
		if(passengerDetails==null) {
			passengerDetails=new ArrayList<PassengerDetails>();
		}else {
			passengerDetails.add(pd);
		}
	}
}
