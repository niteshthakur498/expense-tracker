CREATE TABLE IF NOT EXISTS sm_user_profiles (
	id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone_number VARCHAR(15),
    profile_picture_url VARCHAR(2000),
    verification_status VARCHAR(1),
    last_login TIMESTAMP
);