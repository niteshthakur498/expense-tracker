package com.nitesh.ExpenseTracker.service.impl;

import com.nitesh.ExpenseTracker.dto.ExpenseRequestDTO;
import com.nitesh.ExpenseTracker.dto.ExpenseResponseDTO;
import com.nitesh.ExpenseTracker.entity.Expense;
import com.nitesh.ExpenseTracker.entity.ExpenseId;
import com.nitesh.ExpenseTracker.exception.ResourceNotFoundException;
import com.nitesh.ExpenseTracker.mapper.ExpenseMapper;
import com.nitesh.ExpenseTracker.repository.ExpenseRepository;
import com.nitesh.ExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseMapper expenseMapper;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ExpenseResponseDTO addExpense(ExpenseRequestDTO expenseRequest) {
        Expense expense = expenseMapper.toEntity(expenseRequest);
        Expense cratedExpense = expenseRepository.save(expense);
        return expenseMapper.toResponseDTO(cratedExpense);
    }

    @Override
    public ExpenseResponseDTO updateExpense(String userId,
                                            String expenseId,
                                            ExpenseRequestDTO expenseRequest) {
        ExpenseId expenseKey = new ExpenseId(userId, expenseId);
        Expense existingExpense = expenseRepository.findById(expenseKey)
                .orElseThrow(() -> new ResourceNotFoundException("Expense Record not found for Expense: " + expenseId));
        expenseMapper.map(expenseRequest, existingExpense);
        Expense updatedExpense = expenseRepository.save(existingExpense);
        return expenseMapper.toResponseDTO(updatedExpense);
    }

    @Override
    public void deleteExpense(String userId, String expenseId) {
        ExpenseId expenseKey = new ExpenseId(userId, expenseId);
        Expense expense = expenseRepository.findById(expenseKey)
                .orElseThrow(() -> new ResourceNotFoundException("Expense Record not found for Expense: " + expenseId));
        expenseRepository.deleteById(expenseKey);
    }

    @Override
    public ExpenseResponseDTO getExpenseById(String userId, String expenseId) {
        ExpenseId expenseKey = new ExpenseId(userId, expenseId);
        Expense expense = expenseRepository.findById(expenseKey)
                .orElseThrow(() -> new ResourceNotFoundException("Expense Record not found for Expense: " + expenseId));
        return expenseMapper.toResponseDTO(expense);
    }

    @Override
    public List<ExpenseResponseDTO> getAllUserExpenses(String userId) {
        return expenseRepository.findByUserId(userId)
                .stream()
                .map(expense -> expenseMapper.toResponseDTO(expense))
                .collect(Collectors.toList());
    }
}
