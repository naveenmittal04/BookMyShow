package com.naveenmittal.bookmyshow.exceptions;

public class ShowSeatBlockedException extends RuntimeException{
    public ShowSeatBlockedException() {
        super("Show seat blocked");
    }
}
