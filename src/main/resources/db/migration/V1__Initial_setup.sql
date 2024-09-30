-- V1__Initial_setup.sql

CREATE TABLE users
(
    id               SERIAL PRIMARY KEY,
    email            VARCHAR(255) UNIQUE NOT NULL,
    password         TEXT                NOT NULL,
    first_name       VARCHAR(255)        NOT NULL,
    last_name        VARCHAR(255)        NOT NULL,
    account_enabled  BOOLEAN             NOT NULL DEFAULT TRUE,
    account_locked   BOOLEAN             NOT NULL DEFAULT FALSE,
    created_at       TIMESTAMP(6)                 DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_modified_at TIMESTAMP(6),
    last_login       TIMESTAMP,
    verification_token VARCHAR(255)
);

CREATE TABLE roles
(
    id               SERIAL PRIMARY KEY,
    name             VARCHAR(255) UNIQUE                    NOT NULL,
    created_at       TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_modified_at TIMESTAMP(6)
);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    role_id INTEGER NOT NULL REFERENCES roles (id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE user_profiles
(
    profile_id  SERIAL PRIMARY KEY,
    user_id     INTEGER UNIQUE REFERENCES users (id),
    title       VARCHAR(100),
    description TEXT,
    hourly_rate NUMERIC(10, 2),
    location    VARCHAR(100)
);

CREATE TABLE skills
(
    skill_id   SERIAL PRIMARY KEY,
    skill_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE user_skills
(
    user_id  INTEGER REFERENCES users (id),
    skill_id INTEGER REFERENCES skills (skill_id),
    PRIMARY KEY (user_id, skill_id)
);

CREATE TABLE jobs
(
    job_id      SERIAL PRIMARY KEY,
    client_id   INTEGER REFERENCES users (id),
    title       VARCHAR(255)                                                                    NOT NULL,
    description TEXT                                                                            NOT NULL,
    budget      NUMERIC(10, 2),
    job_type    VARCHAR(10) CHECK (job_type IN ('Hourly', 'Fixed'))                             NOT NULL,
    status      VARCHAR(20) CHECK (status IN ('Open', 'In Progress', 'Completed', 'Cancelled')) NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE job_skills
(
    job_id   INTEGER REFERENCES jobs (job_id),
    skill_id INTEGER REFERENCES skills (skill_id),
    PRIMARY KEY (job_id, skill_id)
);

CREATE TABLE proposals
(
    proposal_id   SERIAL PRIMARY KEY,
    job_id        INTEGER REFERENCES jobs (job_id),
    freelancer_id INTEGER REFERENCES users (id),
    cover_letter  TEXT,
    proposed_rate NUMERIC(10, 2),
    status        VARCHAR(10) CHECK (status IN ('Pending', 'Accepted', 'Rejected')) NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE contracts
(
    contract_id   SERIAL PRIMARY KEY,
    job_id        INTEGER REFERENCES jobs (job_id),
    client_id     INTEGER REFERENCES users (id),
    freelancer_id INTEGER REFERENCES users (id),
    start_date    DATE,
    end_date      DATE,
    status        VARCHAR(10) CHECK (status IN ('Active', 'Completed', 'Terminated')) NOT NULL
);

CREATE TABLE reviews
(
    review_id   SERIAL PRIMARY KEY,
    contract_id INTEGER REFERENCES contracts (contract_id),
    reviewer_id INTEGER REFERENCES users (id),
    reviewee_id INTEGER REFERENCES users (id),
    rating      INTEGER CHECK (rating >= 1 AND rating <= 5),
    comment     TEXT,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE payments
(
    payment_id   SERIAL PRIMARY KEY,
    contract_id  INTEGER REFERENCES contracts (contract_id),
    amount       NUMERIC(10, 2),
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status       VARCHAR(10) CHECK (status IN ('Pending', 'Completed', 'Failed')) NOT NULL
);
