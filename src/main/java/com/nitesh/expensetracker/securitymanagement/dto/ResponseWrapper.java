package com.nitesh.expensetracker.securitymanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper<T> {
    private LocalDateTime timestamp;

    private int status;

    private String message;

    private T info;

    private List<ErrorDetail> errors;


    public ResponseWrapper(int status, String message, T info, List<ErrorDetail> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.info = info;
        this.errors = Objects.requireNonNullElseGet(errors, ArrayList::new);
    }

}
