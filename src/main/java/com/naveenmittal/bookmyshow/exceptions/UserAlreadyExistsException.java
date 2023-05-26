package com.naveenmittal.bookmyshow.exceptions;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException() {
        super("User Already Exists");
    }
}
