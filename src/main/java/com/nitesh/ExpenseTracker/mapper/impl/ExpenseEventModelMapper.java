package com.nitesh.ExpenseTracker.mapper.impl;

import com.nitesh.ExpenseTracker.dto.ExpenseEventRequestDTO;
import com.nitesh.ExpenseTracker.dto.ExpenseEventResponseDTO;
import com.nitesh.ExpenseTracker.dto.ExpenseRequestDTO;
import com.nitesh.ExpenseTracker.entity.ExpenseEvent;
import com.nitesh.ExpenseTracker.mapper.ExpenseEventMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ExpenseEventModelMapper implements ExpenseEventMapper {
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ExpenseEvent toEntity(ExpenseEventRequestDTO expenseEventRequestDTO) {
        return modelMapper.map(expenseEventRequestDTO, ExpenseEvent.class);
    }

    @Override
    public ExpenseEventResponseDTO toResponseDTO(ExpenseEvent expenseEvent) {
        return modelMapper.map(expenseEvent, ExpenseEventResponseDTO.class);
    }

    @Override
    public void map(ExpenseEventRequestDTO expenseRequestDTO, ExpenseEvent existingExpenseEvent) {
        modelMapper.map(expenseRequestDTO, existingExpenseEvent);
    }
}
