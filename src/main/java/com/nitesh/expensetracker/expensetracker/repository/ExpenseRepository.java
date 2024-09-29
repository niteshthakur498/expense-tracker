package com.nitesh.expensetracker.expensetracker.repository;

import com.nitesh.expensetracker.expensetracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUserId(Long userId);

    List<Expense> findByUserIdAndEventId(Long userId,
                                         Long eventId);

    //List<Expense> findByDescriptionContaining(String keyword);

    List<Expense> findByUserIdAndExpenseDateBetween(Long userId,
                                                    LocalDate startDate,
                                                    LocalDate endDate);

    List<Expense> findByUserIdAndPaymentMethod(Long userId,
                                               String paymentMethod);

    //    @Query("Select e.* from et_expense e, et_categories c where e.category_id = c.category_Id and c.category_Id = :categoryId")
    //List<Expense> findByCategoryId(String categoryId);

}
