package com.nitesh.expensetracker.securitymanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserLoginResponseDTO {

    private String email;

    private String accessToken;  // Access token for authentication

    private long accessTokenExpiry;  // Expiration time for access token

    private String refreshToken;  // Refresh token for obtaining a new access token

    private long refreshTokenExpiry;  // Expiration time for refresh token

}
