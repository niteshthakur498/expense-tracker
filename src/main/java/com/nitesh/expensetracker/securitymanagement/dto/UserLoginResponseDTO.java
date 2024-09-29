package com.nitesh.expensetracker.securitymanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserLoginResponseDTO {

    private String email;

    private String tokenType = "Bearer";

    private String accessToken;  // Access token for authentication

    private long accessTokenExpiry;  // Expiration time for access token

    private String refreshToken;  // Refresh token for obtaining a new access token

    private long refreshTokenExpiry;  // Expiration time for refresh token

    private List<String> roles;//Roles also to be sent back to client so that he can act accordingly

}
