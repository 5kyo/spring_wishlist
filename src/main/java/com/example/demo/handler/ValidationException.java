package com.example.demo.handler;

public class ValidationException extends RuntimeException{
    private String message;


    public ValidationException(String message) {
        this.message = message;
    }


    public String getMessage() {
        return this.message;
    }
    
}
