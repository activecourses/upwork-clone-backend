package com.activecourses.upwork.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@Tag(name = "Test", description = "Test API")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Operation(
            summary = "Public access",
            description = "Accessible by anyone",
            security = @SecurityRequirement(name = "")
    )
    @GetMapping("/all")
    public String allAccess() {
        logger.info("Accessing public content");
        return "Public Content.";
    }

    @Operation(
            summary = "Access for all users",
            description = "Accessible by CLIENT, FREELANCER, and ADMIN roles",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping("/user")
    @PreAuthorize("hasRole('CLIENT') or hasRole('FREELANCER') or hasRole('ADMIN')")
    public String allUsersAccess() {
        logger.info("Accessing content for all users");
        return "All Users Content.";
    }

    @Operation(
            summary = "Client access",
            description = "Accessible by CLIENT role",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping("/client")
    @PreAuthorize("hasRole('CLIENT')")
    public String clientAccess() {
        logger.info("Accessing client content");
        return "Client Board.";
    }

    @Operation(
            summary = "Admin access",
            description = "Accessible by ADMIN role",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        logger.info("Accessing admin content");
        return "Admin Board.";
    }

    @Operation(
            summary = "Freelancer access",
            description = "Accessible by FREELANCER role",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping("/freelancer")
    @PreAuthorize("hasRole('FREELANCER')")
    public String freelancerAccess() {
        logger.info("Accessing freelancer content");
        return "Freelancer Board.";
    }
}
