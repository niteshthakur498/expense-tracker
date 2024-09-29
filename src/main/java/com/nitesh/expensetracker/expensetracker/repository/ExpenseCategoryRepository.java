package com.nitesh.expensetracker.expensetracker.repository;

import com.nitesh.expensetracker.expensetracker.entity.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Long> {
}
