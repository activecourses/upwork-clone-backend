package com.activecourses.upwork.service;

import com.activecourses.upwork.model.User;
import com.activecourses.upwork.repository.UserRepository;
import com.activecourses.upwork.service.authentication.AuthServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser() {
        User user = new User();
        user.setFirstName("Ahmed");
        user.setLastName("Muhammed");
        user.setEmail("am0103738@gmail.com");
        user.setPassword("password123");

        // Verify that the UserService correctly calls the passwordEncoder.encode method
        // Just simulate the behavior of the password encoder without actually performing the encoding
        when(passwordEncoder.encode(any(String.class))).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userRepository.findByEmail("am0103738@gmail.com")).thenReturn(Optional.of(user));
        userService.registerUser(user);

        verify(userRepository, times(1)).save(user);
        assertNotNull(userRepository.findByEmail("am0103738@gmail.com"));
        assertEquals("encodedPassword", user.getPassword());
    }
}