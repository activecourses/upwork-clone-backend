package com.activecourses.upwork.controller.auth;

import com.activecourses.upwork.dto.LoginRequestDto;
import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.service.authentication.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/")
public class AuthController {
    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerUser(@RequestBody User user) {
        authService.registerUser(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data("Registration successful! Please check your email to verify.")
                        .build()
                );
    }

    @PostMapping("login")
    public ResponseEntity<ResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(authService.login(loginRequestDto))
                        .build()
                );
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
