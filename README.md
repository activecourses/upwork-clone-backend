# Upwork-Clone

A platform connecting freelancers and clients for job postings, proposals, and real-time chat.

## Table of Contents
- [Setup](#setup)
    - [Database: PostgreSQL](#database-postgresql)
    - [Flyway](#flyway)
- [API Endpoints](#api-endpoints)
    - [Authentication](#authentication)
    - [User Management](#user-management)
    - [Password Management](#password-management)
    - [Token Management](#token-management)
    - [Test Endpoints](#test-endpoints)
- [Swagger UI](#swagger-ui)
- [To-Do](#to-do)

## Setup

### Database: PostgreSQL

<details>
   <summary>Use Docker to create a PostgreSQL container:</summary>

   ```bash
   docker run --name <container-name> -p 5432:5432 -e POSTGRES_PASSWORD=<password> -e POSTGRES_DB=<database-name> -e POSTGRES_USER=<username> -d postgres
   ```
Make sure to replace `<container-name>`, `<password>`, `<database-name>`, and `<username>` with your desired values.
- For testing purposes, you can use this command:
  ```bash
  docker run --name Upwork -p 5432:5432 -e POSTGRES_PASSWORD=root -e POSTGRES_DB=upwork -e POSTGRES_USER=postgres -d postgres
  ```
</details>

<details>
   <summary>Configure Spring Boot to Connect to the Database:</summary>

Create a `src/main/resources/env.properties` file with the following content:
   ```properties
   POSTGRES_USER=<username>
   POSTGRES_PASSWORD=<password>
   POSTGRES_DB=<database-name>
   ```
Replace `<username>`, `<password>`, and `<database-name>` with the values you used when creating the PostgreSQL container.
</details>

### Flyway

Flyway is used to manage database migrations. The SQL scripts are located in `src/main/resources/db/migration`. When you run the application, Flyway will automatically create the necessary tables in the database.

## API Endpoints

### Authentication

<details>
   <summary>Register a new user</summary>

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
    "data": {
      "message": "User registered successfully, please verify your email"
    },
    "error": null
  }
  ```
</details>

<details>
   <summary>Login</summary>

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
  ```
    Login successful: User: hello@gmail.com
  ```
- **Note:** The JWT and Refresh tokens are now sent as HttpOnly cookies.
</details>

<details>
   <summary>Logout</summary>

- **URL:** `/api/auth/logout`
- **Method:** `POST`
- **Description:** Logout a user.
- **Response:**
  ```json
  {
    "status": "OK",
    "success": true,
    "data": "User logged out successfully!",
    "error": null
  }
  ```
</details>

### User Management

<details>
   <summary>Get all users</summary>

- **URL:** `/api/users`
- **Method:** `GET`
- **Description:** Retrieve a paginated list of all users. Only accessible by users with the ROLE_ADMIN role.
- **Query Parameters:**
    - `pageNo` (optional, default: 0): Page number
    - `pageSize` (optional, default: 10): Page size
    - `sortBy` (optional, default: "id"): Sort by field
    - `sortDir` (optional, default: "asc"): Sort direction
- **Response:** A `ResponseDto` object containing the paginated list of users.
</details>

<details>
   <summary>Deactivate user</summary>

- **URL:** `/api/auth/{id}/deactivate`
- **Method:** `POST`
- **Description:** Deactivate a user account.
- **Path Parameters:**
    - `id`: The ID of the user to deactivate
- **Response:** A `ResponseDto` object containing the result of the operation.
</details>

<details>
   <summary>Reactivate user</summary>

- **URL:** `/api/auth/{id}/reactivate`
- **Method:** `POST`
- **Description:** Reactivate a deactivated user account.
- **Path Parameters:**
    - `id`: The ID of the user to reactivate
- **Response:** A `ResponseDto` object containing the result of the operation.
</details>
<details>
   <summary>Get user profile</summary>

- **URL:** `/api/users/profile/{userId}`
- **Method:** `GET`
- **Description:** Retrieve the profile information for a specific user.
- **Path Parameters:**
  - `id` (required): The ID of the user whose profile is to be retrieved.
    - **Response:**
      - **Status Code:** `200 OK`
      - **Body:**
        ```json
        {
        "status": "OK",
        "success": true,
        "data": {
        "id": 160,
        "firstName": "Teddy",
        "lastName": "Johnson",
        "title": null,
        "description": null,
        "hourlyRate": null,
        "location": null
          },
        "error": null
        }
        ```
</details>
<details>
   <summary>Update user profile</summary>

- **URL:** `/api/users/profile/{id}`
- **Method:** `PUT`
- **Description:** Update the profile information for a specific user.
- **Path Parameters:**
  - `id` (required): The ID of the user whose currently logged in.
    - **Request Body:**
      - **Content-Type:** `application/json`
        - **Body Example:**
          ```json
          {
            "id": 160,
            "firstName": "string",
            "lastName": "string",
            "title": "string",
            "description": "string",
            "hourlyRate": 0,
            "location": "string"
          }
          ```
- **Response:**
  - **Status Code:** `200 OK`
  - **Body Example:**
    ```json
        {
        "status": "OK",
        "success": true,
        "data": {
        "id": 160,
        "firstName": "string",
        "lastName": "string",
        "title": "string",
        "description": "string",
        "hourlyRate": 0,
        "location": "string"
          },
        "error": null
        }
    
    ```

</details>

### Password Management

<details>
   <summary>Forgot password</summary>

- **URL:** `/api/auth/forgot-password`
- **Method:** `POST`
- **Description:** Initiate the forgot password process.
- **Note:** This endpoint is to be implemented.
</details>

<details>
   <summary>Reset password</summary>

- **URL:** `/api/auth/reset-password`
- **Method:** `POST`
- **Description:** Reset the user's password.
- **Note:** This endpoint is to be implemented.
</details>

### Token Management

<details>
   <summary>Refresh token</summary>

- **URL:** `/api/auth/refresh-token`
- **Method:** `POST`
- **Description:** Refresh the authentication token.
- **Response:**
  ```json
  {
    "status": "OK",
    "success": true,
    "data": "Token is refreshed successfully!",
    "error": null
  }
  ```
- **Note:** The new JWT and Refresh tokens are sent as HttpOnly cookies. The Refresh token is also stored in the database for better security.
</details>

<details>
   <summary>Verify email</summary>

- **URL:** `/api/auth/verify`
- **Method:** `GET`
- **Description:** Verify the user's email address.
- **Query Parameters:**
    - `token`: The verification token sent to the user's email
- **Response:** A string indicating the result of the verification process.
</details>

<details>
   <summary>Resend verification email</summary>

- **URL:** `/api/auth/resend-verification`
- **Method:** `POST`
- **Description:** Resend the verification email to the user.
- **Query Parameters:**
    - `email`: The email address of the user
- **Response:** A string indicating the result of the operation.
</details>

<details>
   <summary>Delete token</summary>

- **URL:** `/api/auth/delete-token/{id}`
- **Method:** `POST`
- **Description:** Delete a specific token.
- **Path Parameters:**
    - `id`: The ID of the token to delete
- **Response:** An object indicating the result of the operation.
</details>

### Test Endpoints

These endpoints are likely for testing purposes and may be removed in production:

- `/api/test/all`: Accessible to all users
- `/api/test/user`: Accessible to authenticated users
- `/api/test/admin`: Accessible to users with admin role
- `/api/test/client`: Accessible to users with client role
- `/api/test/freelancer`: Accessible to users with freelancer role

## Swagger UI

You can access the Swagger UI documentation for this API at: http://localhost:8080/swagger-ui/index.html

![image](https://github.com/user-attachments/assets/3fa3aad4-68ae-457c-b70e-2efac01b6e2a)

## To-Do

- [ ] Implement the forgot password functionality.
- [ ] Implement the reset password functionality.
- [ ] Add more comprehensive error handling and validation.
- [ ] Add unit and integration tests for all endpoints.
- [ ] Implement logging and monitoring solutions.
- [ ] Create a Dockerfile and build a Docker image for the application.
- [ ] Set up Docker Compose and document Docker setup for the frontend team.