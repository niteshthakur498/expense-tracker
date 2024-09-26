package com.nitesh.expensetracker.securitymanagement.service;

import com.nitesh.expensetracker.securitymanagement.dto.UserLoginRequestDTO;
import com.nitesh.expensetracker.securitymanagement.dto.UserLoginResponseDTO;
import com.nitesh.expensetracker.securitymanagement.dto.UserRegisterRequestDTO;

public interface UserAuthService {

    String registerUser(UserRegisterRequestDTO userRegisterRequestDTO);

    UserLoginResponseDTO login(String email, String password);
}
