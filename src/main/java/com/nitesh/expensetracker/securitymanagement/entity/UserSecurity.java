package com.nitesh.expensetracker.securitymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sm_user_security")
public class UserSecurity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // BIGSERIAL maps to Long

    @Column(name = "user_id", nullable = false)
    private Long userId; // Foreign key to sm_user

    @Column(name = "refresh_token", length = 255)
    private String refreshToken;

    @Column(name = "refresh_token_expiration")
    private LocalDateTime refreshTokenExpiration;

    @Column(name = "is_two_factor_enabled", nullable = false)
    private Boolean isTwoFactorEnabled = false; // Default to FALSE

    @Column(name = "failed_login_attempts", nullable = false)
    private Integer failedLoginAttempts = 0; // Default to 0

    @Column(name = "last_failed_login")
    private LocalDateTime lastFailedLogin;
}
