package com.nitesh.ExpenseTracker.service.impl;

import com.nitesh.ExpenseTracker.dto.ExpenseCategoryDTO;
import com.nitesh.ExpenseTracker.entity.ExpenseCategory;
import com.nitesh.ExpenseTracker.exception.ResourceNotFoundException;
import com.nitesh.ExpenseTracker.mapper.ExpenseCategoryMapper;
import com.nitesh.ExpenseTracker.mapper.ExpenseMapper;
import com.nitesh.ExpenseTracker.repository.ExpenseCategoryRepository;
import com.nitesh.ExpenseTracker.service.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {
    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final ExpenseCategoryMapper expenseCategoryMapper;

    @Autowired
    public ExpenseCategoryServiceImpl(ExpenseCategoryRepository expenseCategoryRepository, ExpenseCategoryMapper expenseCategoryMapper) {
        this.expenseCategoryRepository = expenseCategoryRepository;
        this.expenseCategoryMapper = expenseCategoryMapper;
    }

    @Override
    public List<ExpenseCategoryDTO> getAllCategories() {
        List<ExpenseCategory> expenseCategory = expenseCategoryRepository.findAll();
        return expenseCategory.stream()
                .map(expenseCategoryMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseCategoryDTO getCategory(String categoryId) {
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category Record not found for: " + categoryId));
        return expenseCategoryMapper.toResponseDTO(expenseCategory);
    }
}
