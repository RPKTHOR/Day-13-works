package com.airline.flightreservation.entity;

import java.time.LocalDateTime;

public class Reservation {
	
	private Long id;
	private String passengerName;
	private String passengerEmail;
	private int seatsBooked;
	private LocalDateTime reservedAt;	
	private Flight flight;

	public Reservation(Long id, String passengerName, String passengerEmail, int seatsBooked, LocalDateTime reservedAt,
			Flight flight) {
		this.id = id;
		this.passengerName = passengerName;
		this.passengerEmail = passengerEmail;
		this.seatsBooked = seatsBooked;
		this.reservedAt = reservedAt;
		this.flight = flight;	
	}

	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public LocalDateTime getReservedAt() {
		return reservedAt;
	}

	public void setReservedAt(LocalDateTime reservedAt) {
		this.reservedAt = reservedAt;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
}
