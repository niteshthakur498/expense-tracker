package com.nitesh.expensetracker.securitymanagement.repository;

import com.nitesh.expensetracker.securitymanagement.entity.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSecurityRepository extends JpaRepository<UserSecurity, Long> {
    Optional<UserSecurity> findByUserId(Long userId);

    Optional<UserSecurity> findByUserIdAndRefreshToken(Long userId,
                                                       String refreshToken);
}
