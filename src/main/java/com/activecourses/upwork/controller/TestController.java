package com.activecourses.upwork.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('CLIENT') or hasRole('FREELANCER') or hasRole('ADMIN')")
    public String allUsersAccess() {
        return "All Users Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('CLIENT')")
    public String clientAccess() {
        return "Client Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/freelancer")
    @PreAuthorize("hasRole('FREELANCER')")
    public String freelancerAccess() {
        return "Freelancer Board.";
    }
}