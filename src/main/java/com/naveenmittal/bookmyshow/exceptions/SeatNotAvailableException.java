package com.naveenmittal.bookmyshow.exceptions;

public class SeatNotAvailableException extends RuntimeException{
    public SeatNotAvailableException() {
        super("Seat not available");
    }
}
