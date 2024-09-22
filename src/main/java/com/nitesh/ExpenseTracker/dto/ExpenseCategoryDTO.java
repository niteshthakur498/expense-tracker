package com.nitesh.ExpenseTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseCategoryDTO {
    private String categoryId;

    private String categoryTitle;

    private String categoryDescription;
}