package com.activecourses.upwork.controller.auth;

import com.activecourses.upwork.dto.LoginRequestDto;
import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/")
public class AuthController {
    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("Registration successful! Please check your email to verify.");
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseDto
                            .builder()
                            .status(HttpStatus.OK)
                            .success(true)
                            .data(userService.login(loginRequestDto))
                            .build()
                    );
        } catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ResponseDto
                            .builder()
                            .status(HttpStatus.UNAUTHORIZED)
                            .success(false)
                            .error("email or password is incorrect")
                            .build()
                    );
        }
    }

    @PostMapping("logout")
    public ResponseEntity<?> logout() {
        // TODO: to be implemented
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data("logout successfully")
                        .build()
                );
    }


}
