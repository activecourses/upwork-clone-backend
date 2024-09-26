# Upwork-Clone
Upwork Clone: A platform connecting freelancers and clients for job postings, proposals, real-time chat, and secure payments via escrow.

## Setup
### Database: PostgreSQL
- Use Docker to create a PostgreSQL container:
    ```bash
    docker run --name <container-name> -p 5432:5432 -e POSTGRES_PASSWORD=<password> -e POSTGRES_DB=<database-name> -e POSTGRES_USER=<username> -d postgres
    ```
  Make sure to replace `<container-name>`, `<password>`, `<database-name>`, and `<username>` with your desired values.
  - For testing purposes, you can use this command:
    ```bash
    docker run --name Upwork -p 5432:5432 -e POSTGRES_PASSWORD=root -e POSTGRES_DB=upwork -e POSTGRES_USER=postgres -d postgres
    ```

- Configure Spring Boot to Connect to the Database:
   Create a `src/main/resources/env.properties` file with the following content:
    ```properties
   POSTGRES_USER=<username>
   POSTGRES_PASSWORD=<password>
   POSTGRES_DB=<database-name>
    ```
    Replace `<username>`, `<password>`, and `<database-name>` with the values you used when creating the PostgreSQL container.

### Flyway
Flyway is used to manage database migrations. The SQL scripts are located in `src/main/resources/db/migration`.
When you run the application, Flyway will automatically create the necessary tables in the database.
#### To-Do
- [ ] Add some data to the tables for testing purposes.

### Request:
- **Method**: `POST`
- **Endpoint**: `/login`
- **Body**:
   ```json
   {
     "email": "email_example",
     "password": "password_example"
   }
   ```

### Response:

1. **Success** (`200 OK`):
   ```json
   {
     "<jwt-token>"
   }
   ```

2. **Failure** (`401 Unauthorized`):
   ```json
   {
     "Invalid username or password"
   }
   ``` 

In case of success, the client will receive a JWT token wrapped in a JSON object. If the credentials are incorrect, the response will be a 401 error with an "Invalid username or password" message.
