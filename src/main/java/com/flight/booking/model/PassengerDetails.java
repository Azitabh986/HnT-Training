package com.flight.booking.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import com.flight.booking.enumValue.Gender;

@Entity
@Table(name="passenger_details")
public class PassengerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Range(min=1,max=100)
	private int age;
}
