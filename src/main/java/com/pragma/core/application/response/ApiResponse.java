package com.pragma.core.application.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private LocalDateTime timestamp;
    private boolean success;
    private String message;
    private T data;
    private String errorCode;
    private Integer status;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(LocalDateTime.now(), true, "Operación exitosa", data, null, HttpStatus.OK.value());
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(LocalDateTime.now(), true, message, data, null, HttpStatus.OK.value());
    }

    public static <T> ApiResponse<T> created(T data) {
        return new ApiResponse<>(LocalDateTime.now(), true, "Recurso creado exitosamente", data, null, HttpStatus.CREATED.value());
    }

    public static <T> ApiResponse<T> created(T data, String message) {
        return new ApiResponse<>(LocalDateTime.now(), true, message, data, null, HttpStatus.CREATED.value());
    }

    public static <T> ApiResponse<T> accepted(T data) {
        return new ApiResponse<>(LocalDateTime.now(), true, "Solicitud aceptada", data, null, HttpStatus.ACCEPTED.value());
    }

    public static <T> ApiResponse<T> noContent() {
        return new ApiResponse<>(LocalDateTime.now(), true, "Sin contenido", null, null, HttpStatus.NO_CONTENT.value());
    }

    public static ApiResponse<Void> error(String message, String errorCode, HttpStatus status) {
        return new ApiResponse<>(LocalDateTime.now(), false, message, null, errorCode, status.value());
    }

    public static ApiResponse<Void> badRequest(String message, String errorCode) {
        return error(message, errorCode, HttpStatus.BAD_REQUEST);
    }

    public static ApiResponse<Void> unauthorized(String message, String errorCode) {
        return error(message, errorCode, HttpStatus.UNAUTHORIZED);
    }

    public static ApiResponse<Void> forbidden(String message, String errorCode) {
        return error(message, errorCode, HttpStatus.FORBIDDEN);
    }

    public static ApiResponse<Void> notFound(String message, String errorCode) {
        return error(message, errorCode, HttpStatus.NOT_FOUND);
    }

    public static ApiResponse<Void> conflict(String message, String errorCode) {
        return error(message, errorCode, HttpStatus.CONFLICT);
    }

    public static ApiResponse<Void> unprocessableEntity(String message, String errorCode) {
        return error(message, errorCode, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public static ApiResponse<Void> internalServerError(String message, String errorCode) {
        return error(message, errorCode, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ApiResponse<Void> serviceUnavailable(String message, String errorCode) {
        return error(message, errorCode, HttpStatus.SERVICE_UNAVAILABLE);
    }
}