package com.nitesh.expensetracker.securitymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {
    private String field; // Name of the field with the error
    private String message; // Error message
}
