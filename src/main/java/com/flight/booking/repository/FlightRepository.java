package com.flight.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.booking.model.FlightInfo;

public interface FlightRepository extends JpaRepository<FlightInfo, Integer>{

}
