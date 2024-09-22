package com.nitesh.ExpenseTracker.service;

import com.nitesh.ExpenseTracker.dto.ExpenseRequestDTO;
import com.nitesh.ExpenseTracker.dto.ExpenseResponseDTO;

import java.util.List;

public interface ExpenseService {

    ExpenseResponseDTO addExpense(ExpenseRequestDTO expenseRequest);

    ExpenseResponseDTO updateExpense(String userId,
                                     String expenseId,
                                     ExpenseRequestDTO expenseRequest);

    void deleteExpense(String userId, String expenseId);

    ExpenseResponseDTO getExpenseById(String userId, String expenseId);

    List<ExpenseResponseDTO> getAllUserExpenses(String userId);
}
