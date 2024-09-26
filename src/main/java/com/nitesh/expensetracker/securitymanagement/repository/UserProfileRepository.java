package com.nitesh.expensetracker.securitymanagement.repository;

import com.nitesh.expensetracker.securitymanagement.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
