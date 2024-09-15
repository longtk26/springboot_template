package com.leon.template_rest_api.exception;


public class AuthFailureException extends RuntimeException{
    public AuthFailureException() {
        super("You are not authorized.");
    }
}
