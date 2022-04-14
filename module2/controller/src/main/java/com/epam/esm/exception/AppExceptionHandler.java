package com.epam.esm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.time.LocalDateTime.now;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(TagNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleTagNotFoundException(TagNotFoundException notFoundException) {
        return ErrorResponse.builder()
                .errorMessage(notFoundException.getMessage())
                .errorStatus(HttpStatus.NOT_FOUND)
                .timestamp(now())
                .errorCode(40401)
                .build();
    }

    @ExceptionHandler(GiftCertificateNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleGiftCertificateNotFoundException(GiftCertificateNotFoundException notFoundException) {
        return ErrorResponse.builder()
                .errorMessage(notFoundException.getMessage())
                .errorStatus(HttpStatus.NOT_FOUND)
                .timestamp(now())
                .errorCode(40402)
                .build();
    }

    @ExceptionHandler(GiftCertificatesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleGiftCertificatesNotFoundException(GiftCertificatesNotFoundException notFoundException) {
        return ErrorResponse.builder()
                .errorMessage(notFoundException.getMessage())
                .errorStatus(HttpStatus.NOT_FOUND)
                .timestamp(now())
                .errorCode(40403)
                .build();
    }

    @ExceptionHandler(FieldValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleFieldValidationException(FieldValidationException fieldValidationException) {
        return ErrorResponse.builder()
                .errorMessage(fieldValidationException.getMessage())
                .errorStatus(HttpStatus.BAD_REQUEST)
                .timestamp(now())
                .errorCode(40001)
                .build();
    }
}
