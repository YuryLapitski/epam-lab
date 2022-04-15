package com.epam.esm.service.exception;

public class TagToGiftCertificateReferenceException extends RuntimeException {
    public TagToGiftCertificateReferenceException(String message) {
        super(message);
    }

    public TagToGiftCertificateReferenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
