package com.nitesh.expensetracker.expensetracker.mapper;

import com.nitesh.expensetracker.expensetracker.dto.ExpenseCategoryDTO;
import com.nitesh.expensetracker.expensetracker.entity.ExpenseCategory;

public interface ExpenseCategoryMapper {
    ExpenseCategoryDTO toResponseDTO(ExpenseCategory expenseCategory);
}
