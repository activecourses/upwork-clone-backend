package com.activecourses.upwork.controller.auth;

import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.exception.TokenRefreshException;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.service.authentication.AuthService;
import com.activecourses.upwork.service.RefreshTokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Token", description = "Token API")
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class TokenController {
    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @Operation(
            summary = "Refresh token, to be implemented",
            description = "Refresh token"
    )
    @PostMapping("refresh-token")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) {
        try {
            return refreshTokenService.refreshToken(request);
        } catch (TokenRefreshException e) {
            return ResponseEntity.badRequest().body(ResponseDto.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .success(false)
                    .data(e.getMessage())
                    .build());
        }
    }

    @Operation(
            summary = "Verify email",
            description = "Verify email"
    )
    @GetMapping("/verify")
    public ResponseEntity<String> verifyEmail(@RequestParam String token) {
        if (authService.verifyUser(token)) {
            return ResponseEntity.ok("Email verified successfully!");
        } else {
            return ResponseEntity.badRequest().body("Invalid or expired token.");
        }
    }

    @Operation(
            summary = "Resend verification email",
            description = "Resend verification email"
    )
    @PostMapping("/resend-verification")
    public ResponseEntity<String> resendVerificationEmail(@RequestParam String email) {
        User user = authService.findByEmail(email);
        if (user != null && !user.isEnabled()) {
            authService.sendVerificationEmail(user);
            return ResponseEntity.ok("Verification email resent.");
        }
        return ResponseEntity.badRequest().body("User not found or already verified.");
    }

    @SecurityRequirement(name = "")
    @PostMapping("delete-token/{id}")
    public ResponseEntity<?> deleteToken(@PathVariable int id) {
        int deletedCount = refreshTokenService.deleteByUserId(id);
        if (deletedCount > 0) {
            return ResponseEntity.ok("Refresh token deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
