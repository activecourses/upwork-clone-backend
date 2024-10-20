package com.activecourses.upwork.controller.auth;

import com.activecourses.upwork.config.security.jwt.JwtService;
import com.activecourses.upwork.dto.authentication.login.LoginRequestDto;
import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.dto.authentication.registration.RegistrationRequestDto;
import com.activecourses.upwork.service.authentication.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "Authentication", description = "Authentication API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/")
public class AuthController {
    private final AuthService authService;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Operation(
            summary = "Register a new user",
            description = "Register a new user",
            security = @SecurityRequirement(name = "")
    )
    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerUser(@Valid @RequestBody RegistrationRequestDto registrationRequestDto) {
        logger.info("Registering user with email: {}", registrationRequestDto.getEmail());
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
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        logger.info("User login attempt with email: {}", loginRequestDto.getEmail());
        ResponseDto responseDto = authService.login(loginRequestDto);
        Map<String, ResponseCookie> cookies = (Map<String, ResponseCookie>) responseDto.getData();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookies.get("jwtCookie").toString())
                .header(HttpHeaders.SET_COOKIE, cookies.get("refreshJwtCookie").toString())
                .body("Login successful: User: " + loginRequestDto.getEmail());
    }

    @Operation(
            summary = "Deactivate user",
            description = "Deactivate user",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/deactivate")
    public ResponseDto deactivateUser(@PathVariable int id) {
        logger.info("Deactivating user with id: {}", id);
        boolean success = authService.deactivateUser(id);
        if (success) {
            return ResponseDto.builder()
                    .status(HttpStatus.OK)
                    .success(true)
                    .data("User account deactivated successfully.")
                    .build();
        } else {
            return ResponseDto.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .success(false)
                    .error("User not found.")
                    .build();
        }
    }

    @Operation(
            summary = "Reactivate user",
            description = "Reactivate user",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/reactivate")
    public ResponseDto reactivateUser(@PathVariable int id) {
        logger.info("Reactivating user with id: {}", id);
        boolean success = authService.reactivateUser(id);
        if (success) {
            return ResponseDto.builder()
                    .status(HttpStatus.OK)
                    .success(true)
                    .data("User account reactivated successfully.")
                    .build();
        } else {
            return ResponseDto.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .success(false)
                    .error("User not found.")
                    .build();
        }
    }

    @Operation(
            summary = "Logout",
            description = "Logout",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping("logout")
    public ResponseEntity<?> logout() {
        logger.info("User logout attempt");
        return authService.logout();
    }
}
