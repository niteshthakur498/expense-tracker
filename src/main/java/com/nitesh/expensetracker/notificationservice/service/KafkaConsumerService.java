package com.nitesh.expensetracker.notificationservice.service;

import com.nitesh.expensetracker.kafkaserviceconnect.model.BudgetExceededMessage;
import com.nitesh.expensetracker.kafkaserviceconnect.model.KafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "budget-exceeded", groupId = "${spring.kafka.consumer.group-id}")
    public void listenToBudgetExceededEvent(KafkaMessage event) {
        if (event instanceof BudgetExceededMessage) {
            BudgetExceededMessage budgetEvent = (BudgetExceededMessage) event;
            // Handle the budget exceeded event (e.g., send notification)
            log.info("Budget exceeded for user: {}, amount: {}",
                    budgetEvent.getUserId(),
                    budgetEvent.getAmountExceeded());
        }
    }
}