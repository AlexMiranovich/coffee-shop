package com.agu.coffeeshop.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Objects;

public class BadRequestException extends RuntimeException {
    private ApiErrorCode code;
    private String stringCode;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, ApiErrorCode code) {
        super(message);
        this.code = code;
    }

    public BadRequestException(String message, String stringCode) {
        super(message);
        this.stringCode = stringCode;
    }

    public ApiErrorCode getCode() {
        return code;
    }

    public String getStringCode() {
        return stringCode;
    }

    public ApiError getApiError() {
        String code = Objects.nonNull(getCode()) ? getCode().name() : getStringCode();
        return ApiError.builder()
                .message(getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .code(code)
                .build();
    }
}
