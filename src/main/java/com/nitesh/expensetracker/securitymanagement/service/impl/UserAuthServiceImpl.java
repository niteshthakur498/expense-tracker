package com.nitesh.expensetracker.securitymanagement.service.impl;

import com.nitesh.expensetracker.securitymanagement.dto.UserLoginResponseDTO;
import com.nitesh.expensetracker.securitymanagement.dto.UserRegisterRequestDTO;
import com.nitesh.expensetracker.securitymanagement.entity.User;
import com.nitesh.expensetracker.securitymanagement.entity.UserPreferences;
import com.nitesh.expensetracker.securitymanagement.entity.UserProfile;
import com.nitesh.expensetracker.securitymanagement.exceptions.UserAlreadyExistsException;
import com.nitesh.expensetracker.securitymanagement.mapper.UserMapper;
import com.nitesh.expensetracker.securitymanagement.repository.UserPreferencesRepository;
import com.nitesh.expensetracker.securitymanagement.repository.UserProfileRepository;
import com.nitesh.expensetracker.securitymanagement.repository.UserRepository;
import com.nitesh.expensetracker.securitymanagement.service.UserAuthService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserAuthServiceImpl implements UserAuthService {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final UserPreferencesRepository userPreferencesRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserAuthServiceImpl(UserRepository userRepository,
                               UserMapper userMapper,
                               UserProfileRepository userProfileRepository,
                               UserPreferencesRepository userPreferencesRepository) {
        this.userRepository = userRepository;
        this.userPreferencesRepository = userPreferencesRepository;
        this.userProfileRepository = userProfileRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public String registerUser(UserRegisterRequestDTO userRegisterRequest) {

        if (userRepository.findByEmail(userRegisterRequest.getEmail())
                .isPresent()) {
            throw new UserAlreadyExistsException("Email Already exists....");
        }

        User user = this.userMapper.toEntity(userRegisterRequest);
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
    public UserLoginResponseDTO login(String email,
                                      String password) {
        //User user = this.userRepository.findByEmail(email);
        return null;
    }
}
