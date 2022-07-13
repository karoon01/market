package com.yosypchuk.market.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
