package com.activecourses.upwork.dto.user;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserProfileDto {
    @Id
    private int id;
    @NotBlank(message = "First Name is required")
    private String firstName;
    @NotBlank(message = "Last Name is required")
    private String lastName;

    private String title;

    private String description;

    private BigDecimal hourlyRate;

    private String location;
}
