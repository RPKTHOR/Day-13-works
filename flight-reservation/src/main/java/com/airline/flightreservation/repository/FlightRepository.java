package com.airline.flightreservation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.flightreservation.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{
	Optional<Flight> findByFlightNumber(String flightNumber);
}
