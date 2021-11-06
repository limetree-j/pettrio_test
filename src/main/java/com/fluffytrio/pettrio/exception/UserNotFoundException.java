package com.fluffytrio.pettrio.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String username) {
        super(username + "Not Found Exception");
    }
}
