package com.yosypchuk.market.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public EntityNotFoundException(String message){
        super(message);
    }
}
