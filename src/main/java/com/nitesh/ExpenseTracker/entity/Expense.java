package com.nitesh.ExpenseTracker.entity;

import com.nitesh.ExpenseTracker.utils.IdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "et_expense")
public class Expense {

    //User Input Fields
    @Id
    @Column(name = "user_Id")
    private String userId;

    @Id
    @Column(name = "expense_Id")
    private String expenseId;

    @Column(name = "expense_title")
    private String expenseTitle;

    @Column(name = "expense_description")
    private String expenseDescription;

    @Column(name = "expense_amount")
    private BigDecimal expenseAmount;

    @Column(name = "expense_date")
    private LocalDate expenseDate;

    @Column(name = "expense_location")
    private String expenseLocation;

    @Column(name = "tags")
    private String tags;

    @Column(name = "category_id")
    private String category_id;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "notes")
    private String notes;

    @Column(name = "attachment_id")
    private String attachmentId;

    //optional Field
    @Column(name = "currency")
    private String currency;

    @Column(name = "exchange_rate")
    private BigDecimal exchangeRate;

    //Audit Log
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @PrePersist
    public void generateId(){
        this.expenseId = IdGenerator.generateId("EXP");
    }
}
