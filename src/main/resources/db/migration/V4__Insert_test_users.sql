-- V4__Insert_test_users.sql

-- Insert test users into the users table
INSERT INTO users (email, password, first_name, last_name, account_enabled, account_locked, created_at, last_modified_at, last_login, verification_token)
VALUES
    ('john.doe@example.com', 'password123', 'John', 'Doe', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('jane.smith@example.com', 'password123', 'Jane', 'Smith', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('alice.jones@example.com', 'password123', 'Alice', 'Jones', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('bob.brown@example.com', 'password123', 'Bob', 'Brown', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('charlie.davis@example.com', 'password123', 'Charlie', 'Davis', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('david.johnson@example.com', 'password123', 'David', 'Johnson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('eve.white@example.com', 'password123', 'Eve', 'White', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('frank.miller@example.com', 'password123', 'Frank', 'Miller', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('grace.thompson@example.com', 'password123', 'Grace', 'Thompson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('henry.wilson@example.com', 'password123', 'Henry', 'Wilson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('isabella.moore@example.com', 'password123', 'Isabella', 'Moore', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('jack.taylor@example.com', 'password123', 'Jack', 'Taylor', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('kelly.anderson@example.com', 'password123', 'Kelly', 'Anderson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('liam.jackson@example.com', 'password123', 'Liam', 'Jackson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('mason.harris@example.com', 'password123', 'Mason', 'Harris', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('noah.martin@example.com', 'password123', 'Noah', 'Martin', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('olivia.thompson@example.com', 'password123', 'Olivia', 'Thompson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('peter.scott@example.com', 'password123', 'Peter', 'Scott', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('quinn.mitchell@example.com', 'password123', 'Quinn', 'Mitchell', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('rachel.green@example.com', 'password123', 'Rachel', 'Green', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('sophia.hall@example.com', 'password123', 'Sophia', 'Hall', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('tyler.allen@example.com', 'password123', 'Tyler', 'Allen', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('uma.king@example.com', 'password123', 'Uma', 'King', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('viktor.lee@example.com', 'password123', 'Viktor', 'Lee', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('william.wright@example.com', 'password123', 'William', 'Wright', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('xena.carter@example.com', 'password123', 'Xena', 'Carter', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('yara.baker@example.com', 'password123', 'Yara', 'Baker', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('zachary.clark@example.com', 'password123', 'Zachary', 'Clark', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('aaron.walker@example.com', 'password123', 'Aaron', 'Walker', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('brandon.hall@example.com', 'password123', 'Brandon', 'Hall', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('cynthia.morris@example.com', 'password123', 'Cynthia', 'Morris', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('daniel.harris@example.com', 'password123', 'Daniel', 'Harris', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('erica.carter@example.com', 'password123', 'Erica', 'Carter', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('frances.wright@example.com', 'password123', 'Frances', 'Wright', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('george.bell@example.com', 'password123', 'George', 'Bell', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('hannah.davis@example.com', 'password123', 'Hannah', 'Davis', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('ivan.morris@example.com', 'password123', 'Ivan', 'Morris', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('julia.james@example.com', 'password123', 'Julia', 'James', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('kurt.johnson@example.com', 'password123', 'Kurt', 'Johnson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('laura.martinez@example.com', 'password123', 'Laura', 'Martinez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('matthew.sanchez@example.com', 'password123', 'Matthew', 'Sanchez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('nina.hall@example.com', 'password123', 'Nina', 'Hall', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('oliver.perez@example.com', 'password123', 'Oliver', 'Perez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('paul.morris@example.com', 'password123', 'Paul', 'Morris', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('quincy.sanders@example.com', 'password123', 'Quincy', 'Sanders', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('rita.kim@example.com', 'password123', 'Rita', 'Kim', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('samuel.thompson@example.com', 'password123', 'Samuel', 'Thompson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('tina.ward@example.com', 'password123', 'Tina', 'Ward', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('ursula.wilson@example.com', 'password123', 'Ursula', 'Wilson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('vincent.carter@example.com', 'password123', 'Vincent', 'Carter', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('wendy.garcia@example.com', 'password123', 'Wendy', 'Garcia', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('xander.hall@example.com', 'password123', 'Xander', 'Hall', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('yasmine.gonzalez@example.com', 'password123', 'Yasmine', 'Gonzalez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('zane.roberts@example.com', 'password123', 'Zane', 'Roberts', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('amy.brown@example.com', 'password123', 'Amy', 'Brown', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('brian.johnson@example.com', 'password123', 'Brian', 'Johnson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('chris.miller@example.com', 'password123', 'Chris', 'Miller', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('diana.wright@example.com', 'password123', 'Diana', 'Wright', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('elizabeth.hall@example.com', 'password123', 'Elizabeth', 'Hall', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('franklin.jones@example.com', 'password123', 'Franklin', 'Jones', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('gloria.perez@example.com', 'password123', 'Gloria', 'Perez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('henry.martin@example.com', 'password123', 'Henry', 'Martin', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('irene.thompson@example.com', 'password123', 'Irene', 'Thompson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('jackson.kim@example.com', 'password123', 'Jackson', 'Kim', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('karen.hall@example.com', 'password123', 'Karen', 'Hall', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('linda.johnson@example.com', 'password123', 'Linda', 'Johnson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('martha.brown@example.com', 'password123', 'Martha', 'Brown', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('nick.clark@example.com', 'password123', 'Nick', 'Clark', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('olivia.jones@example.com', 'password123', 'Olivia', 'Jones', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('patricia.smith@example.com', 'password123', 'Patricia', 'Smith', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('quinn.perez@example.com', 'password123', 'Quinn', 'Perez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('richard.wright@example.com', 'password123', 'Richard', 'Wright', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('susan.morris@example.com', 'password123', 'Susan', 'Morris', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('teddy.johnson@example.com', 'password123', 'Teddy', 'Johnson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('uma.james@example.com', 'password123', 'Uma', 'James', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('victor.brown@example.com', 'password123', 'Victor', 'Brown', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('winnie.anderson@example.com', 'password123', 'Winnie', 'Anderson', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('xena.jones@example.com', 'password123', 'Xena', 'Jones', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('yves.davis@example.com', 'password123', 'Yves', 'Davis', TRUE, FALSE, DEFAULT, NULL, NULL, NULL),
    ('zara.martinez@example.com', 'password123', 'Zara', 'Martinez', TRUE, FALSE, DEFAULT, NULL, NULL, NULL);

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
