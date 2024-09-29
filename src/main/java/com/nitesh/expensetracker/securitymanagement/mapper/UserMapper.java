package com.nitesh.expensetracker.securitymanagement.mapper;

import com.nitesh.expensetracker.securitymanagement.dto.UserRegisterRequestDTO;
import com.nitesh.expensetracker.securitymanagement.entity.User;

public interface UserMapper {
    User toEntity(UserRegisterRequestDTO userRegisterRequest);

    UserRegisterRequestDTO toResponseDTO(User user);

    void map(UserRegisterRequestDTO userRegisterRequest,
             User existingUser);
}
