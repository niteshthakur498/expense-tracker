package com.nitesh.expensetracker.securitymanagement.exceptions;

import com.nitesh.expensetracker.securitymanagement.dto.ErrorDetail;
import com.nitesh.expensetracker.securitymanagement.dto.ResponseWrapper;
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
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                ex.getMessage(),
                "",
                null);
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseWrapper<String>> handleUserNotFoundException(UserNotFoundException ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                ex.getMessage(),
                "",
                null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ResponseWrapper<String>> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                ex.getMessage(),
                "",
                null);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(response);
    }

    @ExceptionHandler(AccountLockedException.class)
    public ResponseEntity<ResponseWrapper<String>> handleAccountLockedException(AccountLockedException ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                ex.getMessage(),
                "",
                null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(response);
    }

    @ExceptionHandler(InsufficientPermissionsException.class)
    public ResponseEntity<ResponseWrapper<String>> handleInsufficientPermissionsException(InsufficientPermissionsException ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                ex.getMessage(),
                "",
                null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(response);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ResponseWrapper<String>> handleRoleNotFoundException(RoleNotFoundException ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.OK.value(),
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
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                "Request Field Validations Failed",
                "",
                errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper<String>> handleGenericException(Exception ex) {
        log.warn("Error Message --> {}", ex.getMessage());
        log.debug("Stack Trace --> {}", Arrays.toString(ex.getStackTrace()));
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                "An unexpected error occurred.",
                "",
                null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
