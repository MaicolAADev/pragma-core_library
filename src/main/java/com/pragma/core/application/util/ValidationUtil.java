package com.pragma.core.application.util;

import com.pragma.core.domain.exception.ValidationException;

public class ValidationUtil {

    public static void validateEmail(String email, String fieldName) {
        if (email == null || email.trim().isEmpty()) {
            throw new ValidationException(fieldName + " no puede estar vacío", "VALIDATION_ERROR");
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new ValidationException(fieldName + " tiene un formato inválido", "VALIDATION_ERROR");
        }
    }

    public static void validateNotNull(Object object, String fieldName) {
        if (object == null) {
            throw new ValidationException(fieldName + " no puede ser nulo", "VALIDATION_ERROR");
        }
    }

    public static void validateNotEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new ValidationException(fieldName + " no puede estar vacío", "VALIDATION_ERROR");
        }
    }

    public static void validateRange(double value, double min, double max, String fieldName) {
        if (value < min || value > max) {
            throw new ValidationException(
                    String.format("%s debe estar entre %s y %s", fieldName, min, max),
                    "VALIDATION_ERROR"
            );
        }
    }
}