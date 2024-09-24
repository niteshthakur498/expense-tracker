package com.nitesh.expensetracker.mapper;

import com.nitesh.expensetracker.dto.ExpenseRequestDTO;
import com.nitesh.expensetracker.dto.ExpenseResponseDTO;
import com.nitesh.expensetracker.entity.Expense;

public interface ExpenseMapper {
    Expense toEntity(ExpenseRequestDTO expenseDTO);

    ExpenseResponseDTO toResponseDTO(Expense expense);

    void map(ExpenseRequestDTO expenseRequestDTO, Expense existingExpense);
}
