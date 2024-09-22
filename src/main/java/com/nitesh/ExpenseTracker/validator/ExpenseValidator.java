package com.nitesh.ExpenseTracker.validator;

import com.nitesh.ExpenseTracker.dto.ExpenseRequestDTO;
import com.nitesh.ExpenseTracker.service.ExpenseService;

public interface ExpenseValidator {
    public void validateExpense(ExpenseRequestDTO expenseRequest);
}
