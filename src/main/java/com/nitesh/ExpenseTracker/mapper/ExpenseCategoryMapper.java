package com.nitesh.ExpenseTracker.mapper;

import com.nitesh.ExpenseTracker.dto.ExpenseCategoryDTO;
import com.nitesh.ExpenseTracker.dto.ExpenseResponseDTO;
import com.nitesh.ExpenseTracker.entity.Expense;
import com.nitesh.ExpenseTracker.entity.ExpenseCategory;

public interface ExpenseCategoryMapper {
    ExpenseCategoryDTO toResponseDTO(ExpenseCategory expenseCategory);
}
