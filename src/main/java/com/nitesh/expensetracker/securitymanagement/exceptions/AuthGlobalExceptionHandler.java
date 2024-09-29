package com.nitesh.expensetracker.securitymanagement.exceptions;

import com.nitesh.expensetracker.securitymanagement.dto.ErrorDetail;
import com.nitesh.expensetracker.securitymanagement.dto.ResponseWrapper;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
@Order(1)
@Slf4j
public class AuthGlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ResponseWrapper<String>> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                "",
                null);
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseWrapper<String>> handleUserNotFoundException(UserNotFoundException ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                "",
                null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ResponseWrapper<String>> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(),
                "",
                null);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(response);
    }

    @ExceptionHandler(AccountLockedException.class)
    public ResponseEntity<ResponseWrapper<String>> handleAccountLockedException(AccountLockedException ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.FORBIDDEN.value(),
                ex.getMessage(),
                "",
                null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(response);
    }

    @ExceptionHandler(InsufficientPermissionsException.class)
    public ResponseEntity<ResponseWrapper<String>> handleInsufficientPermissionsException(InsufficientPermissionsException ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.FORBIDDEN.value(),
                ex.getMessage(),
                "",
                null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(response);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ResponseWrapper<String>> handleRoleNotFoundException(RoleNotFoundException ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                "",
                null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseWrapper<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ErrorDetail> errors = new ArrayList<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.add(new ErrorDetail(error.getField(), error.getDefaultMessage())));
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.BAD_REQUEST.value(),
                "Request Field Validations Failed",
                "",
                errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ResponseWrapper<String>> handleExpiredJwtException(Exception ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.UNAUTHORIZED.value(),
                "JWT Token Expired...",
                "",
                null);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(response);
    }


}
