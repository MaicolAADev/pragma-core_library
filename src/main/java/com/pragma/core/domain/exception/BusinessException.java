package com.pragma.core.domain.exception;

public class BusinessException extends DomainException {
    public BusinessException(String message, String errorCode) {
        super(message, errorCode);
    }

    public BusinessException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}