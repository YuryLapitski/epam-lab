package com.epam.esm.service.exception;

public class GiftCertificatesNotFoundException extends RuntimeException {
    public GiftCertificatesNotFoundException(String message) {
        super(message);
    }

    public GiftCertificatesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}