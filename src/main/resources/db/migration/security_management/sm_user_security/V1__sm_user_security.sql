CREATE TABLE IF NOT EXISTS sm_user_security (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    reset_token VARCHAR(255),
    reset_token_expiration TIMESTAMP,
    is_two_factor_enabled BOOLEAN DEFAULT FALSE,
    failed_login_attempts INT DEFAULT 0,
    last_failed_login TIMESTAMP
);