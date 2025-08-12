package com.airline.flightreservation.exception;

public class FlightNotFoundException extends RuntimeException{
	public FlightNotFoundException (String message) {
        super(message);
    }

}
