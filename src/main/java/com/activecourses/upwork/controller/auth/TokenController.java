package com.activecourses.upwork.controller.auth;

import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class TokenController {
    private final UserService userService;

    public TokenController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("refresh-token")
    public ResponseEntity<?> refreshToken() {
        // TODO: to be implemented
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data("refresh token")
                        .build()
                );
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyEmail(@RequestParam String token) {
        if (userService.verifyUser(token)) {
            return ResponseEntity.ok("Email verified successfully!");
        } else {
            return ResponseEntity.badRequest().body("Invalid or expired token.");
        }
    }

    @PostMapping("/resend-verification")
    public ResponseEntity<String> resendVerificationEmail(@RequestParam String email) {
        User user = userService.findByEmail(email);
        if (user != null && !user.isEnabled()) {
            userService.sendVerificationEmail(user);
            return ResponseEntity.ok("Verification email resent.");
        }
        return ResponseEntity.badRequest().body("User not found or already verified.");
    }
}
