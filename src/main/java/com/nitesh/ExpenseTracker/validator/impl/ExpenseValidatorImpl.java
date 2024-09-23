package com.nitesh.ExpenseTracker.validator.impl;

import com.nitesh.ExpenseTracker.dto.ErrorDetail;
import com.nitesh.ExpenseTracker.dto.ExpenseRequestDTO;
import com.nitesh.ExpenseTracker.entity.Expense;
import com.nitesh.ExpenseTracker.entity.ExpenseCategory;
import com.nitesh.ExpenseTracker.exception.ValidationException;
import com.nitesh.ExpenseTracker.repository.ExpenseCategoryRepository;
import com.nitesh.ExpenseTracker.validator.ExpenseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class ExpenseValidatorImpl implements ExpenseValidator {

    private final ExpenseCategoryRepository expenseCategoryRepository;

    @Autowired
    public ExpenseValidatorImpl(ExpenseCategoryRepository expenseCategoryRepository) {
        this.expenseCategoryRepository = expenseCategoryRepository;
    }

    @Override
    public void validateExpense(ExpenseRequestDTO expenseRequest) {
        log.debug("Starting Validating Expense Request..");
        List<ErrorDetail> errors = new ArrayList<>();

        //Validating Amount
        validateAmount(expenseRequest.getExpenseAmount(), errors);

        //Validating Categories
        validateCategory(expenseRequest.getCategoryId(), errors);

        if (!errors.isEmpty()) {
            throw new ValidationException("Validations Failed", errors);
        }
    }

    private void validateCategory(Long categoryId, List<ErrorDetail> errors) {
        log.debug("Starting Validating Expense Category..");
        if (categoryId == null || categoryId <= 0) {
            errors.add(new ErrorDetail("categoryId", "Category Id cannot be null"));
            return;
        }

        Optional<ExpenseCategory> expenseCategory = expenseCategoryRepository.findById(categoryId);

        if (expenseCategory.isEmpty()) {
            errors.add(new ErrorDetail("categoryId", "Invalid Category Id"));
        }
    }

    private void validateAmount(BigDecimal amount, List<ErrorDetail> errors) {
        log.debug("Starting Validating Expense Amount..");
        if (amount.compareTo(new BigDecimal(0)) <= 0) {
            errors.add(new ErrorDetail("expenseAmount", "Expense Amount cannot be less than or Equal to 0"));
        }
    }
}
