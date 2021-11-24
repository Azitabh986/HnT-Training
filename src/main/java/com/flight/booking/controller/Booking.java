package com.flight.booking.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	Map<String,String> handleValidationException(MethodArgumentNotValidException e){
	Map<String,String> hsMap=new HashMap<String, String>();
	e.getBindingResult().getAllErrors().forEach(error->{
		String fieldName=((FieldError) error).getField();
		String defaultMsg=((FieldError) error).getDefaultMessage();
		hsMap.put(fieldName, defaultMsg);
	});
	return hsMap;
}
}
