package com.leon.template_rest_api.exception;


public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(String.format("Bad request because: %s", message));
    }
}
