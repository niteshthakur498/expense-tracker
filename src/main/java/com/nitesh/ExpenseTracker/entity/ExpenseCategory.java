package com.nitesh.ExpenseTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseCategory {

    private String categoryId;

    private String categoryDescription;
}
