package com.nitesh.ExpenseTracker.repository;

import com.nitesh.ExpenseTracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUserId(String userId);

    List<Expense> findByUserIdAndExpenseDateBetween(String userId, LocalDate startDate, LocalDate endDate);

    @Query("Select e.* from et_expense e, et_categories c where e.category_id = c.category_Id and c.category_Id = :categoryId and e.user_id = :userId")
    List<Expense> findByUserIdAndCategory(@Param("userId") String userId, @Param("categoryId") String category);

    List<Expense> findByUserIdAndPaymentMethod(String userId, String paymentMethod);

    List<Expense> findByExpenseDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("Select e.* from et_expense e, et_categories c where e.category_id = c.category_Id and c.category_Id = :categoryId")
    List<Expense> findByCategory(String category);

    List<Expense> findByPaymentMethod(String paymentMethod);
}
