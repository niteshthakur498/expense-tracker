package com.nitesh.ExpenseTracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "et_expense_attachment")
public class ExpenseAttachment {

    @Id
    @Column(name = "attachment_id")
    private String attachmentId;

    @Id
    @Column(name = "expense_id")
    private String expenseId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "upload_date")
    private LocalDate uploadDate;

    @Column(name = "S3_Key")
    private String s3Key;

}
