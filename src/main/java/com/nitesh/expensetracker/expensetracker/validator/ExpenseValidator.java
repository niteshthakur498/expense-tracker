package com.nitesh.expensetracker.expensetracker.validator;

import com.nitesh.expensetracker.expensetracker.dto.ExpenseRequestDTO;

public interface ExpenseValidator {
    public void validateExpense(ExpenseRequestDTO expenseRequest);
}
