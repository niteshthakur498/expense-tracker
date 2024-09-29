package com.nitesh.expensetracker.securitymanagement.service.impl;

import com.nitesh.expensetracker.securitymanagement.entity.UserSecurity;
import com.nitesh.expensetracker.securitymanagement.exceptions.InvalidRefreshTokenException;
import com.nitesh.expensetracker.securitymanagement.repository.UserSecurityRepository;
import com.nitesh.expensetracker.securitymanagement.utils.TimeConversionUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        LocalDateTime refreshTokenExpiry = TimeConversionUtil.convertLongToLocalDateTime(refreshTokenExpiration);
        Optional<UserSecurity> existingUserSecurity = userSecurityRepository.findByUserId(userId);

        UserSecurity userSecurity;
        userSecurity = existingUserSecurity.orElseGet(UserSecurity::new);
        userSecurity.setUserId(userId);
        userSecurity.setRefreshToken(refreshToken);
        userSecurity.setRefreshTokenExpiration(refreshTokenExpiry);
        userSecurityRepository.save(userSecurity);

    }

    public void validateRefreshToken(Long userId,
                                     String refreshToken) {
        UserSecurity userSecurity = userSecurityRepository.findByUserIdAndRefreshToken(userId, refreshToken)
                .orElse(new UserSecurity());

        if (userSecurity.getRefreshToken() == null) {
            throw new InvalidRefreshTokenException("Invalid Refresh Token.");
        }

        if (userSecurity.getRefreshTokenExpiration()
                .isBefore(LocalDateTime.now())) {
            throw new InvalidRefreshTokenException("Refresh Token is Expired.");
        }

    }
}
