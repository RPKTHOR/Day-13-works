package com.airline.flightreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.flightreservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	List<Reservation> findByFlightId(Long flightId);

}
