package com.leon.template_rest_api.exception;

import com.leon.template_rest_api.enums.ResponseCode;
import com.leon.template_rest_api.infrastructure.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.Set;

@RestControllerAdvice
public class GlobalException {
    private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException exception, WebRequest webRequest) {
        return new ErrorResponse<String>(
                "Resource not found",
                ResponseCode.NOTFOUND.code,
                exception.getMessage()
        ).send(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidArgsException.class)
    public ResponseEntity handleInvalidArgsException(InvalidArgsException exception) {
        return new ErrorResponse<Set<String>>(
                exception.getMessage(),
                ResponseCode.INVALID_ARGS.code,
                exception.getListArgs()
        ).send();
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity handleBadRequestException(BadRequestException exception) {
        return new ErrorResponse<String>(
                exception.getMessage(),
                ResponseCode.BAD_REQUEST.code,
                ""
        ).send();
    }

    @ExceptionHandler(AuthFailureException.class)
    public ResponseEntity handleAuthFailureException(AuthFailureException exception) {
        return new ErrorResponse<String>(
                exception.getMessage(),
                ResponseCode.AUTH_FAILURE.code,
                ""
        ).send(HttpStatus.UNAUTHORIZED);
    }
}
