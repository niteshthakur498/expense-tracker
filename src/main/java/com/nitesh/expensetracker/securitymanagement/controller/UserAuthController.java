package com.nitesh.expensetracker.securitymanagement.controller;

import com.nitesh.expensetracker.securitymanagement.dto.ResponseWrapper;
import com.nitesh.expensetracker.securitymanagement.dto.UserRegisterRequestDTO;
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


    @PostMapping("/register")
    ResponseEntity<ResponseWrapper<String>> registerUser(@Valid @RequestBody UserRegisterRequestDTO userRegisterRequest) {
        this.userAuthService.registerUser(userRegisterRequest);
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                "Successfully Registered",
                "",
                null);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);

    }
}
