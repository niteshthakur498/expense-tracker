package com.nitesh.expensetracker.expensetracker.mapper;

import com.nitesh.expensetracker.expensetracker.dto.ExpenseRequestDTO;
import com.nitesh.expensetracker.expensetracker.dto.ExpenseResponseDTO;
import com.nitesh.expensetracker.expensetracker.entity.Expense;

public interface ExpenseMapper {
    Expense toEntity(ExpenseRequestDTO expenseDTO);

    ExpenseResponseDTO toResponseDTO(Expense expense);

    void map(ExpenseRequestDTO expenseRequestDTO,
             Expense existingExpense);
}
