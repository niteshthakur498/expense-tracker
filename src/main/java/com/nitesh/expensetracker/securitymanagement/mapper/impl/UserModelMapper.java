package com.nitesh.expensetracker.securitymanagement.mapper.impl;

import com.nitesh.expensetracker.entity.Expense;
import com.nitesh.expensetracker.securitymanagement.dto.UserRegisterRequestDTO;
import com.nitesh.expensetracker.securitymanagement.entity.User;
import com.nitesh.expensetracker.securitymanagement.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapper implements UserMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public User toEntity(UserRegisterRequestDTO userRegisterRequest) {
        return modelMapper.map(userRegisterRequest, User.class);
    }

    @Override
    public UserRegisterRequestDTO toResponseDTO(User user) {
        return modelMapper.map(user, UserRegisterRequestDTO.class);
    }

    @Override
    public void map(UserRegisterRequestDTO userRegisterRequest, Expense existingUser) {
        modelMapper.map(userRegisterRequest, existingUser);
    }
}
