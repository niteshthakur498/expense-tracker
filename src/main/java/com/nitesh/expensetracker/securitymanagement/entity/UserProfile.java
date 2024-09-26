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
@Table(name = "sm_user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId; // Foreign key to sm_user

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "profile_picture_url", length = 2000)
    private String profilePictureUrl;

    @Column(name = "verification_status", length = 1)
    private String verificationStatus; // VARCHAR(1)

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

}
