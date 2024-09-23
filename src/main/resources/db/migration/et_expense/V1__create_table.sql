CREATE TABLE et_expense (
    expense_Id BIGINT NOT NULL,
    user_Id BIGINT NOT NULL,
    expense_title TEXT NOT NULL,
    expense_description TEXT,
    currency VARCHAR(3),
    expense_amount NUMERIC NOT NULL,
    expense_date DATE NOT NULL,
    expense_location VARCHAR(255),
    tags VARCHAR(2000),
    category_id LONG,
    payment_method VARCHAR(255),
    notes VARCHAR(2000),
    attachment_id LONG,
    exchange_rate NUMERIC,
    expense_input_time TIMESTAMP,
    PRIMARY KEY (expense_Id)
);