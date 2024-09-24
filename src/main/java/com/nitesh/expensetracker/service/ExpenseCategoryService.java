package com.nitesh.expensetracker.service;


import com.nitesh.expensetracker.dto.ExpenseCategoryDTO;

import java.util.List;

public interface ExpenseCategoryService {
    List<ExpenseCategoryDTO> getAllCategories();

    ExpenseCategoryDTO getCategory(Long categoryId);
}
