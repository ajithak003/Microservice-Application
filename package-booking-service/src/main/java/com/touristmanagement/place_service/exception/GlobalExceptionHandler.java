package com.touristmanagement.place_service.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomServiceException.class)
    public ResponseEntity<Map<String, Object>> handleCustomServiceException(CustomServiceException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", ex.getStatus());
        return new ResponseEntity<>(errorResponse, ex.getStatus());
        
    }
}