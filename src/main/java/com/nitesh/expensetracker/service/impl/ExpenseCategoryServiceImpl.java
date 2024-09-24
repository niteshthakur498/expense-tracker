package com.nitesh.expensetracker.service.impl;

import com.nitesh.expensetracker.dto.ExpenseCategoryDTO;
import com.nitesh.expensetracker.entity.ExpenseCategory;
import com.nitesh.expensetracker.exception.ResourceNotFoundException;
import com.nitesh.expensetracker.mapper.ExpenseCategoryMapper;
import com.nitesh.expensetracker.repository.ExpenseCategoryRepository;
import com.nitesh.expensetracker.service.ExpenseCategoryService;
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
    public ExpenseCategoryDTO getCategory(Long categoryId) {
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category Record not found for: " + categoryId));
        return expenseCategoryMapper.toResponseDTO(expenseCategory);
    }
}
