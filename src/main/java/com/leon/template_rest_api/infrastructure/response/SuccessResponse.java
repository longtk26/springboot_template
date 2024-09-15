package com.leon.template_rest_api.infrastructure.response;

import com.leon.template_rest_api.enums.ResponseCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@RequiredArgsConstructor
public class SuccessResponse<T> {
    private final String message;
    private final Integer code;
    private final T data;

    public ResponseEntity<T> send(HttpStatus httpStatus) {
        SuccessResponse<T> response = new SuccessResponse<>(this.message, this.code, this.data);

        return new ResponseEntity(response, httpStatus);
    }

    public ResponseEntity<T> send() {
        return this.send(HttpStatus.OK);
    }
}
