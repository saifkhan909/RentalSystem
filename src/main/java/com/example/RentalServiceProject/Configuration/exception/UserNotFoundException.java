package com.example.RentalServiceProject.Configuration.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
