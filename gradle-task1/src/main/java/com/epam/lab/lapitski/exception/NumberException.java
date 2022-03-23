package com.epam.lab.lapitski.exception;

public class NumberException extends Exception {

    public NumberException(String message) {
        super(message);
    }

    public NumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
