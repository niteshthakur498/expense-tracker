CREATE TABLE et_expense_attachment (
    attachment_id VARCHAR(255) NOT NULL,
    expense_id VARCHAR(255) NOT NULL,
    file_name VARCHAR(255),
    mime_type VARCHAR(100),
    upload_date DATE,
    s3_key VARCHAR(255),
    PRIMARY KEY (attachment_id, expense_id)
);
