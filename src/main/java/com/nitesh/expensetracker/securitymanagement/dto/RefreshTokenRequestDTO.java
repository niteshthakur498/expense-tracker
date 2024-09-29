package com.nitesh.expensetracker.securitymanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefreshTokenRequestDTO {

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Refresh Token is required")
    private String refreshToken;
}