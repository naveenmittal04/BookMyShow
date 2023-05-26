package com.naveenmittal.bookmyshow.exceptions;

public class ShowNotFoundException extends RuntimeException{
    public ShowNotFoundException() {
        super("Show not found");
    }
}
