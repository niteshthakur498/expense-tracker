package com.nitesh.ExpenseTracker.mapper;

import com.nitesh.ExpenseTracker.dto.ExpenseRequestDTO;
import com.nitesh.ExpenseTracker.dto.ExpenseResponseDTO;
import com.nitesh.ExpenseTracker.entity.Expense;

public interface ExpenseMapper {
    Expense toEntity(ExpenseRequestDTO expenseDTO);

    ExpenseResponseDTO toResponseDTO(Expense expense);

    void map(ExpenseRequestDTO expenseRequestDTO, Expense existingExpense);
}
