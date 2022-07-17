package com.yosypchuk.market.controller;

import com.yosypchuk.market.exception.EntityAlreadyExistException;
import com.yosypchuk.market.exception.EntityNotFoundException;
import com.yosypchuk.market.model.error.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandlingController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleEntityNotFoundException(EntityNotFoundException e) {
        log.info("handleEntityNotFoundException: {}", e.getMessage(), e);
        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, e.getMessage(), e));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = EntityAlreadyExistException.class)
    public ResponseEntity<ApiError> handleEntityAlreadyExistException(EntityAlreadyExistException e) {
        log.info("handleEntityNotFoundException: {}", e.getMessage(), e);
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, e.getMessage(), e));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseEntity<ApiError> handleAuthenticationException(BadCredentialsException e) {
        log.info("handleEntityNotFoundException: {}", e.getMessage(), e);
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, e.getMessage(), e));
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> handleAccessDeniedException(AccessDeniedException e) {
        log.error("handleAccessDenied: {}", e.getMessage(), e);
        return buildResponseEntity(new ApiError(HttpStatus.FORBIDDEN, e.getMessage(), e));
    }

    public ResponseEntity<ApiError> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
