package com.leon.template_rest_api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;

@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidArgsException extends RuntimeException{
    private final Set<String> listArgs;

    public InvalidArgsException(Set<String> listArgs) {
        super("Invalid arguments exception");
        this.listArgs = listArgs;
    }
}
