package com.nitesh.expensetracker.expensetracker.exception;

import com.nitesh.expensetracker.expensetracker.dto.ErrorDetail;
import com.nitesh.expensetracker.expensetracker.dto.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseWrapper<EmptyResponse>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        EmptyResponse emptyResponse = new EmptyResponse();
        ResponseWrapper<EmptyResponse> errorResponse = new ResponseWrapper<>(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                emptyResponse,
                new ArrayList<>()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class) // Custom validation exception
    public ResponseEntity<ResponseWrapper<EmptyResponse>> handleValidationException(ValidationException ex) {
        List<ErrorDetail> errorDetails = ex.getErrors(); // Assuming this method returns a list of ErrorDetail
        EmptyResponse emptyResponse = new EmptyResponse();
        ResponseWrapper<EmptyResponse> errorResponse = new ResponseWrapper<>(
                HttpStatus.BAD_REQUEST.value(),
                "Validation failed",
                emptyResponse,
                errorDetails
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper<EmptyResponse>> handleGenericException(Exception ex) {
        log.error("Error Message is ", ex);

        EmptyResponse emptyResponse = new EmptyResponse();
        ResponseWrapper<EmptyResponse> errorResponse = new ResponseWrapper<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred." + ex.getMessage(),
                emptyResponse,
                new ArrayList<>()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
