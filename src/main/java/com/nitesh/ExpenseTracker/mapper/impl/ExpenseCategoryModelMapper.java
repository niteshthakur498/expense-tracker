package com.nitesh.ExpenseTracker.mapper.impl;

import com.nitesh.ExpenseTracker.dto.ExpenseCategoryDTO;
import com.nitesh.ExpenseTracker.dto.ExpenseResponseDTO;
import com.nitesh.ExpenseTracker.entity.Expense;
import com.nitesh.ExpenseTracker.entity.ExpenseCategory;
import com.nitesh.ExpenseTracker.mapper.ExpenseCategoryMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ExpenseCategoryModelMapper implements ExpenseCategoryMapper {
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ExpenseCategoryDTO toResponseDTO(ExpenseCategory expenseCategory) {
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true);
        return modelMapper.map(expenseCategory, ExpenseCategoryDTO.class);
    }

}
