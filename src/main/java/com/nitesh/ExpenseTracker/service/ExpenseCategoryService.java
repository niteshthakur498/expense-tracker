package com.nitesh.ExpenseTracker.service;


import com.nitesh.ExpenseTracker.dto.ExpenseCategoryDTO;

import java.util.List;

public interface ExpenseCategoryService {
    List<ExpenseCategoryDTO> getAllCategories();

    ExpenseCategoryDTO getCategory(Long categoryId);
}
