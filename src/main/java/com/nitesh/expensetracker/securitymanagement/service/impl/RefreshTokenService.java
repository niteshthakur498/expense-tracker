package com.nitesh.expensetracker.securitymanagement.service.impl;

import com.nitesh.expensetracker.securitymanagement.entity.UserSecurity;
import com.nitesh.expensetracker.securitymanagement.repository.UserSecurityRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private final UserSecurityRepository userSecurityRepository;


    public RefreshTokenService(UserSecurityRepository userSecurityRepository) {
        this.userSecurityRepository = userSecurityRepository;
    }

    @Value("${security.jwt.refresh-expiration-time}")
    private long refreshTokenExpiration;


    public long getRefreshExpirationTime() {
        return refreshTokenExpiration;
    }

    public String generateRefreshToken() {
        return UUID.randomUUID()
                .toString();
    }

    public void updateRefreshToken(Long userId,
                                   String refreshToken,
                                   long refreshTokenExpiration) {

        LocalDateTime refreshTokenExpiry = LocalDateTime.ofInstant(Instant.ofEpochMilli(refreshTokenExpiration),
                ZoneId.systemDefault());

        Optional<UserSecurity> existingUserSecurity = userSecurityRepository.findByUserId(userId);

        UserSecurity userSecurity;
        userSecurity = existingUserSecurity.orElseGet(UserSecurity::new);
        userSecurity.setUserId(userId);
        userSecurity.setResetToken(refreshToken);
        userSecurity.setResetTokenExpiration(refreshTokenExpiry);
        userSecurityRepository.save(userSecurity);

    }
}
