package com.nitesh.expensetracker.kafkaserviceconnect.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetExceededMessage implements KafkaMessage {

    private Long userId;
    private BigDecimal amountExceeded;
    private String eventType = "BUDGET_EXCEEDED";

    public BudgetExceededMessage(Long userId,
                                 BigDecimal amountExceeded) {
        this.userId = userId;
        this.amountExceeded = amountExceeded;
    }
}
