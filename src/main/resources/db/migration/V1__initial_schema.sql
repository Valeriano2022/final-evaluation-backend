-- ==============================
-- USERS TABLE
-- ==============================
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password_hashed VARCHAR(255) NOT NULL,

    created_at TIMESTAMP NOT NULL,
    created_by BIGINT,
    updated_at TIMESTAMP NOT NULL,
    updated_by BIGINT
);

-- ==============================
-- ACTIVITY TYPES TABLE
-- ==============================
CREATE TABLE activity_types (
    id BIGSERIAL PRIMARY KEY,
    activity_name VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL,
    created_by BIGINT,
    updated_at TIMESTAMP NOT NULL,
    updated_by BIGINT
);

-- ==============================
-- ACTIVITY LOGS TABLE
-- ==============================
CREATE TABLE activity_logs (
    id BIGSERIAL PRIMARY KEY,
    student_id BIGINT NOT NULL,
    activity_type_id BIGINT NOT NULL,
    title VARCHAR(255),
    description TEXT NOT NULL,
    duration_minutes INT,
    date DATE NOT NULL,
    start_time TIME,
    end_time TIME,

    created_at TIMESTAMP NOT NULL,
    created_by BIGINT,
    updated_at TIMESTAMP NOT NULL,
    updated_by BIGINT,

    CONSTRAINT fk_activitylog_student
        FOREIGN KEY (student_id) REFERENCES users(id)
            ON DELETE CASCADE,

    CONSTRAINT fk_activitylog_type
        FOREIGN KEY (activity_type_id) REFERENCES activity_types(id)
            ON DELETE RESTRICT
);

-- ==============================
-- TOKENS TABLE
-- ==============================
CREATE TABLE tokens (
    id BIGSERIAL PRIMARY KEY,
    version BIGINT,
    token VARCHAR(255) UNIQUE NOT NULL,
    expired BOOLEAN DEFAULT FALSE,
    revoked BOOLEAN DEFAULT FALSE,

    user_id BIGINT NOT NULL,

    created_at TIMESTAMP NOT NULL,
    created_by BIGINT,
    updated_at TIMESTAMP NOT NULL,
    updated_by BIGINT,

    CONSTRAINT fk_token_user
        FOREIGN KEY (user_id) REFERENCES users(id)
            ON DELETE CASCADE
);