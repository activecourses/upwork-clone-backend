package com.activecourses.upwork.controller.auth;

import com.activecourses.upwork.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class PasswordController {

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
