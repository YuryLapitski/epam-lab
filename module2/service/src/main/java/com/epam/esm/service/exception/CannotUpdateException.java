package com.epam.esm.service.exception;

public class CannotUpdateException extends RuntimeException {
    public CannotUpdateException(String message) {
        super(message);
    }

    public CannotUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
