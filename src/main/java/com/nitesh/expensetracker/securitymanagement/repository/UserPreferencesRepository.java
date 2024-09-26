package com.nitesh.expensetracker.securitymanagement.repository;

import com.nitesh.expensetracker.securitymanagement.entity.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferencesRepository extends JpaRepository<UserPreferences, Long> {
}
