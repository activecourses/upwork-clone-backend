package com.activecourses.upwork.controller.auth;

import com.activecourses.upwork.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Password", description = "Password API")
@RestController
@RequestMapping("/api/auth")
public class PasswordController {

    @Operation(
            summary = "Forgot password, to be implemented",
            description = "Forgot password"
    )
    @PostMapping("forgot-password")
    public ResponseEntity<?> forgotPassword() {
        // TODO: to be implemented
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data("forgot password")
                        .build()
                );
    }

    @Operation(
            summary = "Reset password, to be implemented",
            description = "Reset password"
    )
    @PostMapping("reset-password")
    public ResponseEntity<?> resetPassword() {
        // TODO: to be implemented
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data("reset password")
                        .build()
                );
    }
}
