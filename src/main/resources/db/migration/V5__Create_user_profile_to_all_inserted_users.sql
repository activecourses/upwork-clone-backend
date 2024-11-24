INSERT INTO user_profiles (user_id)
SELECT u.id
FROM users u
         LEFT JOIN user_profiles up ON u.id = up.user_id
WHERE up.user_id IS NULL;