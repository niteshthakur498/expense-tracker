CREATE TABLE IF NOT EXISTS sm_user_preferences (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    language_preference VARCHAR(10),
    timezone VARCHAR(50)
);