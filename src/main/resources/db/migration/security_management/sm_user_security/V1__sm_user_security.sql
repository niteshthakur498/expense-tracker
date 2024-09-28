CREATE TABLE IF NOT EXISTS sm_user_security (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    refresh_token VARCHAR(255),
    refresh_token_expiration TIMESTAMP,
    is_two_factor_enabled BOOLEAN DEFAULT FALSE,
    failed_login_attempts INT DEFAULT 0,
    last_failed_login TIMESTAMP
);