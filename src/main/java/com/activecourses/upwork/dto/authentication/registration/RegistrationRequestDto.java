package com.activecourses.upwork.dto.authentication.registration;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestDto {
    @NotEmpty(message = "First name is required")
    @NotNull(message = "First name is required")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @NotNull(message = "Last name is required")
    private String lastName;

    @Email(message = "Email is not valid")
    @NotEmpty(message = "Email is required")
    @NotNull(message = "Email is required")
    private String email;

    @NotEmpty(message = "Password is required")
    @NotNull(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotEmpty(message = "Roles are required")
    private List<String> roles;  // "ROLE_FREELANCER", "ROLE_CLIENT" and "ROLE_ADMIN"
}