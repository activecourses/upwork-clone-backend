# Upwork-Clone

A platform connecting freelancers and clients for job postings, proposals, and real-time chat.

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
  Replace `<username>`, `<password>`, and `<database-name>` with the values you used when creating the PostgreSQL
  container.

### Flyway

Flyway is used to manage database migrations. The SQL scripts are located in `src/main/resources/db/migration`.
When you run the application, Flyway will automatically create the necessary tables in the database.

#### To-Do

- [ ] Add some data to the tables for testing purposes.

## API Endpoints

You can access Swagger UI from this link: http://localhost:8080/swagger-ui/index.html

![Screenshot 2024-10-01 at 13-09-32 Swagger UI](https://github.com/user-attachments/assets/4848fef9-31ff-4fc5-87c5-e1ac097360a0)

### Authentication

- **Register a new user**
    - **URL:** `/api/auth/register`
    - **Method:** `POST`
    - **Description:** Register a new user.
    - **Request Body:**
      ```json
      {
        "firstName": "string",
        "lastName": "string",
        "email": "string",
        "password": "string",
        "roles": ["string"]
      }
      ```
    - **Response:**
      ```json
      {
        "status": "OK",
        "success": true,
        "data": "User registered successfully, please verify your email"
      }
      ```

- **Login**
    - **URL:** `/api/auth/login`
    - **Method:** `POST`
    - **Description:** Login a user.
    - **Request Body:**
      ```json
      {
        "email": "string",
        "password": "string"
      }
      ```
    - **Response:**
      ```json
      {
        "status": "OK",
        "success": true,
        "data": {
          "accessToken": "string",
          "refreshToken": "string"
        }
      }
      ```

- **Logout** (To be implemented)
    - **URL:** `/api/auth/logout`
    - **Method:** `POST`
    - **Description:** Logout a user.
    - **Response:**
      ```json
      {
        "status": "OK",
        "success": true,
        "data": "logout successfully"
      }
      ```

### Token

- **Refresh token** (To be implemented)
    - **URL:** `/api/auth/refresh-token`
    - **Method:** `POST`
    - **Description:** Refresh the authentication token.
    - **Response:**
      ```json
      {
        "status": "OK",
        "success": true,
        "data": "refresh token"
      }
      ```
