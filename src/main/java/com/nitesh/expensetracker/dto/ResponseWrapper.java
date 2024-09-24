package com.nitesh.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper<T> {
    private LocalDateTime timestamp;

    private int status;

    private String message;

    private T data;

    private List<ErrorDetail> errors;


    public ResponseWrapper(int status, String message, T data, List<ErrorDetail> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.data = data;
        this.errors = errors;
    }

}
