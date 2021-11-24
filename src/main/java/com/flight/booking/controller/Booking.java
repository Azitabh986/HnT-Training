package com.flight.booking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flight.booking.model.FlightInfo;
import com.flight.booking.service.BookingService;

@RestController
@RequestMapping("/api/v1.0")
public class Booking {

	@Autowired
	private BookingService bookingService;
	@PostMapping("/airlines")
	public ResponseEntity<FlightInfo> saveFlight(@Valid @RequestBody FlightInfo flight) {
		FlightInfo f=bookingService.saveFlightInfo(flight);
		return new ResponseEntity<FlightInfo>(f,HttpStatus.CREATED);
	}
}
