package com.nitesh.expensetracker.securitymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sm_user_preferences")
public class UserPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // BIGSERIAL maps to Long

    @Column(name = "user_id", nullable = false)
    private Long userId; // Foreign key to sm_user

    @Column(name = "language_preference")
    private String languagePreference;

    @Column(name = "timezone")
    private String timezone;
}
