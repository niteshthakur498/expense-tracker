package com.nitesh.expensetracker.expensetracker.mapper.impl;

import com.nitesh.expensetracker.expensetracker.dto.ExpenseEventRequestDTO;
import com.nitesh.expensetracker.expensetracker.dto.ExpenseEventResponseDTO;
import com.nitesh.expensetracker.expensetracker.entity.ExpenseEvent;
import com.nitesh.expensetracker.expensetracker.mapper.ExpenseEventMapper;
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
    public void map(ExpenseEventRequestDTO expenseRequestDTO,
                    ExpenseEvent existingExpenseEvent) {
        modelMapper.map(expenseRequestDTO, existingExpenseEvent);
    }
}
