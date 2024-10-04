-- V4__Insert_test_users.sql

-- Insert test users into the users table
INSERT INTO users (email, password, first_name, last_name, account_enabled, account_locked, created_at, last_modified_at, last_login, verification_token)
VALUES
    ('john.doe@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'John', 'Doe', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('jane.smith@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Jane', 'Smith', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('alice.jones@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Alice', 'Jones', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('bob.brown@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Bob', 'Brown', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('charlie.davis@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Charlie', 'Davis', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('david.johnson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'David', 'Johnson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('eve.white@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Eve', 'White', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('frank.miller@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Frank', 'Miller', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('grace.thompson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Grace', 'Thompson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('henry.wilson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Henry', 'Wilson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('isabella.moore@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Isabella', 'Moore', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('jack.taylor@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Jack', 'Taylor', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('kelly.anderson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Kelly', 'Anderson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('liam.jackson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Liam', 'Jackson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('mason.harris@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Mason', 'Harris', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('noah.martin@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Noah', 'Martin', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('olivia.thompson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Olivia', 'Thompson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('peter.scott@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Peter', 'Scott', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('quinn.mitchell@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Quinn', 'Mitchell', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('rachel.green@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Rachel', 'Green', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('sophia.hall@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Sophia', 'Hall', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('tyler.allen@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Tyler', 'Allen', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('uma.king@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Uma', 'King', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('viktor.lee@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Viktor', 'Lee', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('william.wright@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'William', 'Wright', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('xena.carter@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Xena', 'Carter', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('yara.baker@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Yara', 'Baker', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('zachary.clark@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Zachary', 'Clark', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('aaron.walker@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Aaron', 'Walker', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('brandon.hall@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Brandon', 'Hall', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('cynthia.morris@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Cynthia', 'Morris', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('daniel.harris@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Daniel', 'Harris', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('erica.carter@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Erica', 'Carter', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('frances.wright@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Frances', 'Wright', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('george.bell@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'George', 'Bell', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('hannah.davis@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Hannah', 'Davis', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('ivan.morris@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Ivan', 'Morris', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('julia.james@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Julia', 'James', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('kurt.johnson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Kurt', 'Johnson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('laura.martinez@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Laura', 'Martinez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('matthew.sanchez@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Matthew', 'Sanchez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('nina.hall@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Nina', 'Hall', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('oliver.perez@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Oliver', 'Perez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('paul.morris@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Paul', 'Morris', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('quincy.sanders@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Quincy', 'Sanders', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('rita.kim@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Rita', 'Kim', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('samuel.thompson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Samuel', 'Thompson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('tina.ward@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Tina', 'Ward', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('ursula.wilson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Ursula', 'Wilson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('vincent.carter@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Vincent', 'Carter', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('wendy.garcia@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Wendy', 'Garcia', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('xander.hall@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Xander', 'Hall', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('yasmine.gonzalez@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Yasmine', 'Gonzalez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('zane.roberts@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Zane', 'Roberts', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('amy.brown@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Amy', 'Brown', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('brian.johnson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Brian', 'Johnson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('chris.miller@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Chris', 'Miller', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('diana.wright@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Diana', 'Wright', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('elizabeth.hall@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Elizabeth', 'Hall', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('franklin.jones@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Franklin', 'Jones', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('gloria.perez@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Gloria', 'Perez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('henry.martin@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Henry', 'Martin', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('irene.thompson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Irene', 'Thompson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('jackson.kim@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Jackson', 'Kim', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('karen.hall@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Karen', 'Hall', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('linda.johnson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Linda', 'Johnson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('martha.brown@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Martha', 'Brown', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('nick.clark@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Nick', 'Clark', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('olivia.jones@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Olivia', 'Jones', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('patricia.smith@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Patricia', 'Smith', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('quinn.perez@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Quinn', 'Perez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('richard.wright@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Richard', 'Wright', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('susan.morris@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Susan', 'Morris', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('teddy.johnson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Teddy', 'Johnson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('uma.james@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Uma', 'James', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('victor.brown@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Victor', 'Brown', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('winnie.anderson@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Winnie', 'Anderson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('xena.jones@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Xena', 'Jones', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('yves.davis@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Yves', 'Davis', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('zara.martinez@example.com', '$2b$12$wYRUVFvCBgb6eC9LVxsSwOXXl99NZHfeViO7njRUf0Yj0gPX1B7Dq', 'Zara', 'Martinez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL);

-- Assign role 'admin' to the first 5 users, 'client' to the next 20 users, and 'freelancer' to users starting from user 26
WITH ranked_users AS (
    SELECT id,
           ROW_NUMBER() OVER (ORDER BY id) AS rn -- Use appropriate ordering criteria
    FROM users
)
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM ranked_users u
JOIN roles r ON (
        (u.rn <= 5 AND r.name = 'ROLE_ADMIN') OR
        (u.rn > 5 AND u.rn <= 25 AND r.name = 'ROLE_CLIENT') OR
        (u.rn > 25 AND r.name = 'ROLE_FREELANCER')  -- Assign ROLE_FREELANCER to users starting from 26
    )
WHERE u.rn <= (SELECT COUNT(*) FROM users);  -- Limit to the total number of users
