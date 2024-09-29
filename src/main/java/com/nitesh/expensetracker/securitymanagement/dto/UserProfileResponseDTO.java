package com.nitesh.expensetracker.securitymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponseDTO {
    private Long id; // Unique identifier of the profile

    private Long userId; // Foreign key reference

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String profilePictureUrl;

    private String verificationStatus; // e.g., "V" for Verified

    private LocalDateTime lastLogin;

    private LocalDateTime createdAt; // Timestamp for when the profile was created

    private LocalDateTime updatedAt; // Timestamp for when the profile was last updated
}
