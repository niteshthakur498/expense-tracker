package com.nitesh.expensetracker.validator;

import com.nitesh.expensetracker.dto.ExpenseRequestDTO;

public interface ExpenseValidator {
    public void validateExpense(ExpenseRequestDTO expenseRequest);
}
