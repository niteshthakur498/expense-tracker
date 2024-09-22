CREATE TABLE et_expense_event (
    event_id BIGINT,
    user_id  BIGINT,
    event_title TEXT,
    event_description TEXT,
    event_input_time    TIMESTAMP,
    event_status VARCHAR(1),
    PRIMARY KEY (event_id)
);