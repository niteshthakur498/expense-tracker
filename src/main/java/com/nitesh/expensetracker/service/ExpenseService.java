package com.nitesh.expensetracker.service;

import com.nitesh.expensetracker.dto.ExpenseRequestDTO;
import com.nitesh.expensetracker.dto.ExpenseResponseDTO;

import java.util.List;

public interface ExpenseService {

    ExpenseResponseDTO addExpense(ExpenseRequestDTO expenseRequest);

    ExpenseResponseDTO updateExpense(Long userId,
                                     Long expenseId,
                                     ExpenseRequestDTO expenseRequest);

    void deleteExpense(Long userId, Long expenseId);

    ExpenseResponseDTO getExpenseById(Long userId, Long expenseId);

    List<ExpenseResponseDTO> getAllUserExpenses(Long userId);

    List<ExpenseResponseDTO> getExpenseByUserAndEvent(Long userId, Long eventID);
}
