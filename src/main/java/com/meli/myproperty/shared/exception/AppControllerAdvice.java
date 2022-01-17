package com.meli.myproperty.shared.exception;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        HttpStatus unprocessableEntity = HttpStatus.UNPROCESSABLE_ENTITY;

        for (FieldError field : exception.getBindingResult().getFieldErrors()) {
            System.out.println("Errors:\n" + field.getField() + ": " + field.getDefaultMessage());
            errors.put(field.getField(), field.getDefaultMessage());
        }

        AppErrorResponse errorResponse = new AppErrorResponse(
                Date.from(Instant.now()),
                unprocessableEntity.value(),
                unprocessableEntity.name(),
                exception.getMessage(),
                errors);

        return new ResponseEntity<>(errorResponse, unprocessableEntity);
    }

    @ExceptionHandler(NotFoundElementException.class)
    public ResponseEntity<AppErrorResponse> handleNotFoundElementException(
            NotFoundElementException exception) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        AppErrorResponse errorResponse = new AppErrorResponse(
                Date.from(Instant.now()),
                badRequest.value(),
                badRequest.name(),
                exception.getMessage(),
                null);

        return new ResponseEntity<>(errorResponse, badRequest);
    }
}
