package com.flight.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.flight.booking.model.FlightInfo;
import com.flight.booking.repository.FlightRepository;

@Service
public class BookingService {

	@Autowired
	private FlightRepository flightRepository;
	
	public FlightInfo saveFlightInfo(FlightInfo flight) {
		return flightRepository.save(flight);
	}

}
