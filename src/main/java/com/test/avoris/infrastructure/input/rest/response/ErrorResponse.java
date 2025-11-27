package com.test.avoris.infrastructure.input.rest.response;

import java.time.LocalDateTime;

public class ErrorResponse {
    private final int status;
    private final String message;
    private final LocalDateTime timestamp;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}