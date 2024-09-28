package com.nitesh.expensetracker.securitymanagement.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RefreshTokenService {
    @Value("${security.jwt.refresh-expiration-time}")
    private long refreshTokenExpiration;


    public long getRefreshExpirationTime() {
        return refreshTokenExpiration;
    }

    public String generateRefreshToken() {
        return UUID.randomUUID()
                .toString();
    }
}
