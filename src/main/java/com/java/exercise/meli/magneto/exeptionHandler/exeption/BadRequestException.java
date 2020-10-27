package com.java.exercise.meli.magneto.exeptionHandler.exeption;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
