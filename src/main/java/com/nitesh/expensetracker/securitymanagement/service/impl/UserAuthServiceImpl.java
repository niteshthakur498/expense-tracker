package com.nitesh.expensetracker.securitymanagement.service.impl;

import com.nitesh.expensetracker.securitymanagement.dto.RefreshTokenRequestDTO;
import com.nitesh.expensetracker.securitymanagement.dto.UserLoginRequestDTO;
import com.nitesh.expensetracker.securitymanagement.dto.UserLoginResponseDTO;
import com.nitesh.expensetracker.securitymanagement.dto.UserRegisterRequestDTO;
import com.nitesh.expensetracker.securitymanagement.entity.User;
import com.nitesh.expensetracker.securitymanagement.entity.UserPreferences;
import com.nitesh.expensetracker.securitymanagement.entity.UserProfile;
import com.nitesh.expensetracker.securitymanagement.entity.UserSecurity;
import com.nitesh.expensetracker.securitymanagement.exceptions.UserAlreadyExistsException;
import com.nitesh.expensetracker.securitymanagement.exceptions.UserNotFoundException;
import com.nitesh.expensetracker.securitymanagement.mapper.UserMapper;
import com.nitesh.expensetracker.securitymanagement.repository.UserPreferencesRepository;
import com.nitesh.expensetracker.securitymanagement.repository.UserProfileRepository;
import com.nitesh.expensetracker.securitymanagement.repository.UserRepository;
import com.nitesh.expensetracker.securitymanagement.repository.UserSecurityRepository;
import com.nitesh.expensetracker.securitymanagement.service.UserAuthService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

@Service
@Slf4j
public class UserAuthServiceImpl implements UserAuthService {
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final UserPreferencesRepository userPreferencesRepository;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    @Autowired
    public UserAuthServiceImpl(UserRepository userRepository,
                               UserMapper userMapper,
                               UserProfileRepository userProfileRepository,
                               UserPreferencesRepository userPreferencesRepository,
                               AuthenticationManager authenticationManager,
                               PasswordEncoder passwordEncoder,
                               JwtService jwtService,
                               RefreshTokenService refreshTokenService) {
        this.userRepository = userRepository;
        this.userPreferencesRepository = userPreferencesRepository;
        this.userProfileRepository = userProfileRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.jwtService = jwtService;
        this.refreshTokenService = refreshTokenService;

    }

    @Override
    @Transactional
    public String signup(UserRegisterRequestDTO userRegisterRequest) {

        if (userRepository.findByEmail(userRegisterRequest.getEmail())
                .isPresent()) {
            log.warn("Attempt to register with existing email: {}", userRegisterRequest.getEmail());
            throw new UserAlreadyExistsException("Email Already exists....");
        }

        User user = this.userMapper.toEntity(userRegisterRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User createdUser = this.userRepository.save(user);

        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(createdUser.getId());
        userProfileRepository.save(userProfile);

        UserPreferences userPreferences = new UserPreferences();
        userPreferences.setUserId(createdUser.getId());
        userPreferencesRepository.save(userPreferences);

        return "";
    }

    @Override
    public UserLoginResponseDTO login(UserLoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        log.debug("Security Authentication working fine.......");
        User authenticatedUser = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException("Uer Not found....."));

        //List<GrantedAuthority> roles = (List<GrantedAuthority>) authentication.getAuthorities();
        log.debug("accessToken Generated.......");
        String accessToken = jwtService.generateToken(authenticatedUser);
        String refreshToken = refreshTokenService.generateRefreshToken();
        log.debug("refreshToken Token Generated.....");

        long accessTokenExpirationUnix = System.currentTimeMillis() + jwtService.getExpirationTime();
        long refreshTokenExpirationUnix = System.currentTimeMillis() + refreshTokenService.getRefreshExpirationTime();
        refreshTokenService.updateRefreshToken(authenticatedUser.getId(), refreshToken, refreshTokenExpirationUnix);


        return new UserLoginResponseDTO(
                loginRequest.getEmail(),
                "Bearer",
                accessToken,
                accessTokenExpirationUnix,
                refreshToken,
                refreshTokenExpirationUnix,
                new ArrayList<>()
        );
    }

    @Override
    public UserLoginResponseDTO refreshToken(RefreshTokenRequestDTO refreshTokenRequest) {

        User user = userRepository.findByEmail(refreshTokenRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found.."));

        refreshTokenService.validateRefreshToken(user.getId(), refreshTokenRequest.getRefreshToken());

        String accessToken = jwtService.generateToken(user);
        String refreshToken = refreshTokenService.generateRefreshToken();
        long accessTokenExpirationUnix = System.currentTimeMillis() + jwtService.getExpirationTime();
        long refreshTokenExpirationUnix = System.currentTimeMillis() + refreshTokenService.getRefreshExpirationTime();
        refreshTokenService.updateRefreshToken(user.getId(), refreshToken, refreshTokenExpirationUnix);

        return new UserLoginResponseDTO(
                user.getEmail(),
                "Bearer",
                accessToken,
                accessTokenExpirationUnix,
                refreshToken,
                refreshTokenExpirationUnix,
                new ArrayList<>()
        );
    }


}
