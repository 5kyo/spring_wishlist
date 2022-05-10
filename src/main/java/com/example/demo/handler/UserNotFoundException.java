package com.example.demo.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserNotFoundException extends RuntimeException{
    
    @ResponseBody
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<?> userHandlerException(ValidationException validationMessage){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(validationMessage.getMessage());
    }
}
