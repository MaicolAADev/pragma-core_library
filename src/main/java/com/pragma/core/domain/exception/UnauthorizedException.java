package com.pragma.core.domain.exception;

public class UnauthorizedException extends DomainException {
    public UnauthorizedException(String message, String errorCode) {
        super(message, errorCode);
    }

    public UnauthorizedException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}