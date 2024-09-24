package com.nitesh.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseCategoryDTO {
    private Long categoryId;

    private String categoryTitle;

    private String categoryDescription;
}
