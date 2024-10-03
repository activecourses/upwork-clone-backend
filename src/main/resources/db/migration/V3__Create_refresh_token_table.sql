CREATE TABLE refresh_tokens
(
    id          SERIAL PRIMARY KEY,
    token       VARCHAR(255) NOT NULL,
    expiry_date TIMESTAMP    NOT NULL,
    user_id     INTEGER      NOT NULL UNIQUE,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id)
);