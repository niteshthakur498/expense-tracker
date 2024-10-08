package com.nitesh.expensetracker.securitymanagement.exceptions;

import com.nitesh.expensetracker.securitymanagement.dto.ErrorDetail;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {
    private final List<ErrorDetail> errors;

    public ValidationException(String message,
                               List<ErrorDetail> errors) {
        super(message);
        this.errors = errors;
    }

}
