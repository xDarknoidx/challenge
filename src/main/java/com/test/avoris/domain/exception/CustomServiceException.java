package com.test.avoris.domain.exception;

import org.springframework.http.HttpStatus;

public class CustomServiceException extends RuntimeException {

    private HttpStatus status;

    public CustomServiceException(HttpStatus status, String message) {
        super(message);
    }
}
