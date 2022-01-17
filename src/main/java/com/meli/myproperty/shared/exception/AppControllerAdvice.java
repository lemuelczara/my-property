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
            errors.put(field.getField(), field.getDefaultMessage());
        }

        var response = AppErrorResponse.builder()
                .timestamp(Date.from(Instant.now()))
                .code(unprocessableEntity.value())
                .status(unprocessableEntity.name())
                .message(exception.getMessage())
                .data(errors)
                .build();

        return new ResponseEntity<>(response, unprocessableEntity);
    }

    @ExceptionHandler(NotFoundElementException.class)
    public ResponseEntity<AppErrorResponse> handleNotFoundElementException(
        NotFoundElementException exception) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        var response = AppErrorResponse.builder()
                .timestamp(Date.from(Instant.now()))
                .code(badRequest.value())
                .status(badRequest.name())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(response, badRequest);
    }
}
