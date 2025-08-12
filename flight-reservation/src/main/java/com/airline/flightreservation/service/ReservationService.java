package com.airline.flightreservation.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.airline.flightreservation.dto.ReservationRequest;
import com.airline.flightreservation.entity.Flight;
import com.airline.flightreservation.entity.Reservation;
import com.airline.flightreservation.exception.FlightNotFoundException;
import com.airline.flightreservation.exception.NotEnoughSeatsException;
import com.airline.flightreservation.repository.FlightRepository;
import com.airline.flightreservation.repository.ReservationRepository;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final FlightRepository flightRepository;

    public ReservationService(ReservationRepository reservationRepository, FlightRepository flightRepository) {
        this.reservationRepository = reservationRepository;
        this.flightRepository = flightRepository;
    }

    public Reservation makeReservation(ReservationRequest request) {
        Flight flight = flightRepository.findById(request.getFlightId())
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));

        if (request.getSeatsBooked() > flight.getSeatsAvailable()) {
            throw new NotEnoughSeatsException("Not enough seats available");
        }

        flight.setSeatsAvailable(flight.getSeatsAvailable() - request.getSeatsBooked());
        flightRepository.save(flight);

        Reservation reservation = new Reservation();
        reservation.setPassengerName(request.getPassengerName());
        reservation.setPassengerEmail(request.getPassengerEmail());
        reservation.setSeatsBooked(request.getSeatsBooked());
        reservation.setReservedAt(LocalDateTime.now());
        reservation.setFlight(flight);

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByFlight(Long flightId) {
        return reservationRepository.findByFlightId(flightId);
    }

    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new FlightNotFoundException("Reservation not found"));

        Flight flight = reservation.getFlight();
        flight.setSeatsAvailable(flight.getSeatsAvailable() + reservation.getSeatsBooked());
        flightRepository.save(flight);

        reservationRepository.delete(reservation);
    }
}
