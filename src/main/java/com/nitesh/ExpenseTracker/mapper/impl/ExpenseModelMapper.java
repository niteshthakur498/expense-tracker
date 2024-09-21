package com.nitesh.ExpenseTracker.mapper.impl;

import com.nitesh.ExpenseTracker.dto.ExpenseRequestDTO;
import com.nitesh.ExpenseTracker.dto.ExpenseResponseDTO;
import com.nitesh.ExpenseTracker.entity.Expense;
import com.nitesh.ExpenseTracker.mapper.ExpenseMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ExpenseModelMapper implements ExpenseMapper {
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Expense toEntity(ExpenseRequestDTO expenseDTO) {
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true);
        return modelMapper.map(expenseDTO, Expense.class);
    }

    @Override
    public ExpenseResponseDTO toResponseDTO(Expense expense) {
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true);
        return modelMapper.map(expense, ExpenseResponseDTO.class);
    }

    @Override
    public void map(ExpenseRequestDTO expenseRequestDTO, Expense existingExpense) {
        modelMapper.map(expenseRequestDTO, existingExpense);
    }
}
