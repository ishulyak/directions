package com.shulyaq.google.exception;

public class DirectionNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Could not find specified direction. " + super.getMessage();
    }
}
