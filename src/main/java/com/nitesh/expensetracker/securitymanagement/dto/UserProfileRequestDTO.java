package com.nitesh.expensetracker.securitymanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileRequestDTO {

    private Long id; // Optional for creation, but necessary for updates

    @NotBlank(message = "User ID is required")
    private Long userId; // Foreign key reference

    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String firstName;

    @Size(max = 50, message = "Last name must not exceed 50 characters")
    private String lastName;

    @Size(max = 15, message = "Phone number must not exceed 15 characters")
    private String phoneNumber;

    @Size(max = 2000, message = "Profile picture URL must not exceed 2000 characters")
    private String profilePictureUrl;

    @Size(max = 1, message = "Verification status must be a single character")
    private String verificationStatus; // e.g., "V" for Verified

    private LocalDateTime lastLogin;

}
