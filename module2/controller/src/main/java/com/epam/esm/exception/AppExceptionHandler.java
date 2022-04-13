package com.epam.esm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.time.LocalDateTime.now;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(EntityNotFoundException notFoundException) {
        return ErrorResponse.builder()
                .errorMessage(notFoundException.getMessage())
                .errorStatus(HttpStatus.NOT_FOUND)
                .timestamp(now())
                .errorCode(40401)
                .build();
    }

    @ExceptionHandler(FieldValidationException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorResponse handleFieldValidationException(FieldValidationException fieldValidationException) {
        return ErrorResponse.builder()
                .errorMessage(fieldValidationException.getMessage())
                .errorStatus(HttpStatus.NOT_ACCEPTABLE)
                .timestamp(now())
                .errorCode(40601)
                .build();
    }
}
