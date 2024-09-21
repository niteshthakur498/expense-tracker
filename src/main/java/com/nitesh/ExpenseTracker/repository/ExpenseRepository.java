package com.nitesh.ExpenseTracker.repository;

import com.nitesh.ExpenseTracker.entity.Expense;
import com.nitesh.ExpenseTracker.entity.ExpenseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, ExpenseId> {

    List<Expense> findByUserId(String userId);

    //List<Expense> findByDescriptionContaining(String keyword);

    List<Expense> findByUserIdAndExpenseDateBetween(String userId,
                                                    LocalDate startDate,
                                                    LocalDate endDate);

    List<Expense> findByUserIdAndPaymentMethod(String userId,
                                               String paymentMethod);

    //    @Query("Select e.* from et_expense e, et_categories c where e.category_id = c.category_Id and c.category_Id = :categoryId")
    //List<Expense> findByCategoryId(String categoryId);

}
