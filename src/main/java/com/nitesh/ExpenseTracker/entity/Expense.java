package com.nitesh.ExpenseTracker.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    //User Input Fields
    private String userId;

    private String expenseId;

    private String expenseDescription;

    private BigDecimal expenseAmount;

    private LocalDate expenseDate;

    private String expenseLocation;

    private String tags;

    private String category;

    private String paymentMethod;

    private String notes;

    private String attachmentId;

    //optional Field
    private String currency;

    private BigDecimal exchangeRate;

    //Audit Log
    private LocalDate creationDate;


}
