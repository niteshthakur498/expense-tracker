CREATE TABLE et_expense (
    user_Id VARCHAR(255) NOT NULL,
    expense_Id VARCHAR(255) NOT NULL,
    expense_description VARCHAR(255),
    expense_amount DECIMAL(19, 2) NOT NULL,
    expense_date DATE NOT NULL,
    expense_location VARCHAR(255),
    tags VARCHAR(255),
    category_id VARCHAR(255),
    payment_method VARCHAR(255),
    notes VARCHAR(255),
    attachment_id VARCHAR(255),
    currency VARCHAR(255),
    exchange_rate DECIMAL(19, 2),
    creation_date DATE,
    PRIMARY KEY (user_Id, expense_Id)
);