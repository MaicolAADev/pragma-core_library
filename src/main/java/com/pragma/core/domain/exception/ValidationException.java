package com.pragma.core.domain.exception;

public class ValidationException extends DomainException {
    public ValidationException(String message, String errorCode) {
        super(message, errorCode);
    }

    public ValidationException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}