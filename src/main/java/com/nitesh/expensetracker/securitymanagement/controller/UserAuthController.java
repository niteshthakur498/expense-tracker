package com.nitesh.expensetracker.securitymanagement.controller;

import com.nitesh.expensetracker.securitymanagement.dto.*;
import com.nitesh.expensetracker.securitymanagement.service.UserAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserAuthController {

    private final UserAuthService userAuthService;

    @Autowired
    public UserAuthController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }


    @PostMapping("/signup")
    ResponseEntity<ResponseWrapper<String>> signup(@Valid @RequestBody UserRegisterRequestDTO userRegisterRequest) {
        this.userAuthService.signup(userRegisterRequest);
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                "Successfully Registered",
                "",
                null);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);

    }

    @PostMapping("/login")
    ResponseEntity<ResponseWrapper<UserLoginResponseDTO>> registerUser(@Valid @RequestBody UserLoginRequestDTO loginRequest) {
        UserLoginResponseDTO loginResponse = this.userAuthService.login(loginRequest);
        ResponseWrapper<UserLoginResponseDTO> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                "Successfully Login",
                loginResponse,
                null);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);

    }

    @PostMapping("/refresh-token")
    ResponseEntity<ResponseWrapper<UserLoginResponseDTO>> registerUser(@Valid @RequestBody RefreshTokenRequestDTO refreshTokenRequest) {
        UserLoginResponseDTO loginResponse = this.userAuthService.refreshToken(refreshTokenRequest);
        ResponseWrapper<UserLoginResponseDTO> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                "Successfully Login",
                loginResponse,
                null);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);

    }
}
