package com.blog.api.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This class provides global exception handling for the Blog API.
 *
 * @Author Nishant
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    /**
     * Exception handler for the ResourceNotFoundException.
     *
     * @param ex The ResourceNotFoundException instance.
     * @return A ResponseEntity containing an ApiResponse and HTTP status.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
    
    /**
     * Exception handler for the MethodArgumentNotValidException.
     *
     * @param ex The MethodArgumentNotValidException instance.
     * @return A ResponseEntity containing a Map of field errors and HTTP status.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName, message);
        });
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }
}
