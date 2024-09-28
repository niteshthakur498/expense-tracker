package com.nitesh.expensetracker.securitymanagement.service;

import com.nitesh.expensetracker.securitymanagement.dto.UserLoginRequestDTO;
import com.nitesh.expensetracker.securitymanagement.dto.UserLoginResponseDTO;
import com.nitesh.expensetracker.securitymanagement.dto.UserRegisterRequestDTO;

public interface UserAuthService {

    String signup(UserRegisterRequestDTO userRegisterRequestDTO);

    UserLoginResponseDTO login(UserLoginRequestDTO loginRequest);
}
