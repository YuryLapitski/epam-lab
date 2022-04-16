package com.epam.esm.service.exception;

public class InvalidSortTypeException extends RuntimeException {
    public InvalidSortTypeException(String message) {
        super(message);
    }

    public InvalidSortTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
