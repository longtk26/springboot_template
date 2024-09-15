package com.leon.template_rest_api.enums;


public enum ResponseCode {
    SUCCESS(2001),
    ACCEPT(2002),
    INVALID_ARGS(4010),
    NOTFOUND(4000),
    BAD_REQUEST(4002),
    AUTH_FAILURE(4005);

    public final Integer code;

    ResponseCode(Integer code) {
        this.code = code;
    }
}
