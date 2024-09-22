package com.nitesh.ExpenseTracker.repository;

import com.nitesh.ExpenseTracker.entity.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, String> {
}
