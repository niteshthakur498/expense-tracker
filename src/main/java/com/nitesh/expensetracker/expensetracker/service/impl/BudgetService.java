package com.nitesh.expensetracker.expensetracker.service.impl;


import com.nitesh.expensetracker.expensetracker.entity.ExpenseEvent;
import com.nitesh.expensetracker.expensetracker.repository.ExpenseEventRepository;
import com.nitesh.expensetracker.expensetracker.repository.ExpenseRepository;
import com.nitesh.expensetracker.kafkaserviceconnect.dto.PublishMessageRequestDto;
import com.nitesh.expensetracker.kafkaserviceconnect.model.BudgetExceededMessage;
import com.nitesh.expensetracker.kafkaserviceconnect.model.KafkaMessage;
import com.nitesh.expensetracker.kafkaserviceconnect.util.KafkaServiceClientUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Service
@Slf4j
public class BudgetService {

    //Add functionality for event budget

    //Add Monthly Budget

    private final ExpenseRepository expenseRepository;
    private final ExpenseEventRepository expenseEventRepository;
    private final KafkaServiceClientUtility kafkaServiceClientUtility;

    @Autowired
    public BudgetService(ExpenseRepository expenseRepository,
                         KafkaServiceClientUtility kafkaServiceClientUtility,
                         ExpenseEventRepository expenseEventRepository) {
        this.expenseRepository = expenseRepository;
        this.kafkaServiceClientUtility = kafkaServiceClientUtility;
        this.expenseEventRepository = expenseEventRepository;
    }

    public void processBudgetFunctionality(Long userId,
                                           Long eventId) {
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.withDayOfMonth(1); // First day of current month
        LocalDate endOfMonth = today.with(TemporalAdjusters.lastDayOfMonth()); // Last day of current month
        log.info("Range is : {} to {}", startOfMonth, endOfMonth);


        if (eventId == null) {
            return;
        }

//        BigDecimal totalExpensesForMonth = expenseRepository.sumExpensesForCurrentMonth(userId,
//                startOfMonth,
//                endOfMonth);

        BigDecimal totalExpensesForEvent = expenseRepository.sumExpensesForEvent(userId, eventId);
        ExpenseEvent expenseEvent = expenseEventRepository.findById(eventId)
                .orElse(null);
        log.info(String.valueOf(totalExpensesForEvent));

        /*publishing event to kafka*/
        try {
            if (expenseEvent != null && expenseEvent.getBudget()
                    .compareTo(totalExpensesForEvent) < 0) {
                KafkaMessage budgetExceededMessage = new BudgetExceededMessage(userId,
                        totalExpensesForEvent);
                ResponseEntity<String> response = kafkaServiceClientUtility.publishMessage(new PublishMessageRequestDto(
                        "budget-exceeded", budgetExceededMessage));
            }

        } catch (Exception e) {
            log.error("Failed while publishing message {}", e.getMessage());
        }

    }

}
