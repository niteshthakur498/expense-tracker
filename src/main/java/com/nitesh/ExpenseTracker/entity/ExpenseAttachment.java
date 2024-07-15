package com.nitesh.ExpenseTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseAttachment {
    private String attachmentId;

    private String expenseId;

    private String fileName;

    private String mimeType;

    private LocalDate uploadedAt;

    private String s3Key;

}
