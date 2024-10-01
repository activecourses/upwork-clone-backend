package com.activecourses.upwork.controller.auth;

import com.activecourses.upwork.dto.authentication.login.LoginRequestDto;
import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.dto.authentication.registration.RegistrationRequestDto;
import com.activecourses.upwork.service.authentication.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication", description = "Authentication API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/")
public class AuthController {
    private final AuthService authService;

    @Operation(
            summary = "Register a new user",
            description = "Register a new user",
            security = @SecurityRequirement(name = "")
    )
    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerUser(@Valid @RequestBody RegistrationRequestDto registrationRequestDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(authService.registerUser(registrationRequestDto))
                        .build()
                );
    }

    @Operation(
            summary = "Login",
            description = "Login",
            security = @SecurityRequirement(name = "")
    )
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

    @Operation(
            summary = "Logout, to be implemented",
            description = "Logout",
            security = @SecurityRequirement(name = "bearerAuth")
    )
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
