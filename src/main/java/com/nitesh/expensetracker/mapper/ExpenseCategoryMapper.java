package com.nitesh.expensetracker.mapper;

import com.nitesh.expensetracker.dto.ExpenseCategoryDTO;
import com.nitesh.expensetracker.entity.ExpenseCategory;

public interface ExpenseCategoryMapper {
    ExpenseCategoryDTO toResponseDTO(ExpenseCategory expenseCategory);
}
