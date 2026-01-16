package com.example.WeatherAPI.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@SuppressWarnings("unused")
public class GlobalExceptionHandler {

    @SuppressWarnings("unused")
    @ExceptionHandler(WeatherApiException.class)
    public ResponseEntity<String> handle(WeatherApiException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
