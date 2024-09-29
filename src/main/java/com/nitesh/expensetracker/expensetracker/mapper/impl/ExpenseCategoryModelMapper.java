package com.nitesh.expensetracker.expensetracker.mapper.impl;

import com.nitesh.expensetracker.expensetracker.dto.ExpenseCategoryDTO;
import com.nitesh.expensetracker.expensetracker.entity.ExpenseCategory;
import com.nitesh.expensetracker.expensetracker.mapper.ExpenseCategoryMapper;
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
