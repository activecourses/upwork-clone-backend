package com.activecourses.upwork.controller.auth;

import com.activecourses.upwork.config.security.CustomeUserDetailsService;
import com.activecourses.upwork.config.security.jwt.JwtService;
import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.service.authentication.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Token", description = "Token API")
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class TokenController {
    private final AuthService authService;
    private final JwtService jwtService;
    private final CustomeUserDetailsService userDetailsService;

    @Operation(
            summary = "Refresh token, to be implemented",
            description = "Refresh token"
    )
    @PostMapping("refresh-token")
    public ResponseEntity<ResponseDto> refreshToken(HttpServletRequest request) {
        String refreshToken = jwtService.getJwtRefreshFromCookies(request);

        if (refreshToken != null && jwtService.validateJwtToken(refreshToken)) {
            String username = jwtService.getUserNameFromJwtToken(refreshToken);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // Generate new access token
            String newAccessToken = jwtService.generateAccessToken(userDetails);
            ResponseCookie jwtCookie = jwtService.generateJwtCookie((User) userDetails);

            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                    .body(ResponseDto.builder()
                            .status(HttpStatus.OK)
                            .success(true)
                            .data("New access token generated")
                            .build());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseDto.builder()
                    .status(HttpStatus.UNAUTHORIZED)
                    .success(false)
                    .data("Invalid refresh token")
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
}
