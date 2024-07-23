package com.pasteleria.pasteleria_app.exception;

public class CustomExceptions extends RuntimeException {
    private final String errorCode;

    public CustomExceptions(String message) {
        super(message);
        this.errorCode = null;
    }

    public CustomExceptions(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}