package com.epam.esm.service.exception;

public class GiftCertificateAlreadyExistException extends RuntimeException {
    public GiftCertificateAlreadyExistException(String message) {
        super(message);
    }

    public GiftCertificateAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
