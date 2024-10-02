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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication", description = "Authentication API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/")
public class AuthController {
    private final AuthService authService;
    private final JwtService jwtService;

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
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        ResponseDto responseDto = authService.login(loginRequestDto);
        ResponseCookie jwtCookie = (ResponseCookie) responseDto.getData();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body("User logged in successfully!");
    }

    @Operation(
            summary = "Logout",
            description = "Logout",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping("logout")
    public ResponseEntity<?> logout() {
        ResponseCookie jwtCookie = jwtService.getCleanJwtCookie();
        ResponseCookie refreshJwtCookie = jwtService.getCleanJwtRefreshCookie();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .header(HttpHeaders.SET_COOKIE, refreshJwtCookie.toString())
                .body(ResponseDto
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data("User logged out successfully!")
                        .build()
                );
    }

//    @Operation(
//            summary = "Refresh token",
//            description = "Refresh access token using refresh token",
//            security = @SecurityRequirement(name = "")
//    )
//    @PostMapping("refresh-token")
//    public ResponseEntity<?> refreshToken(HttpServletRequest request) {
//        String refreshToken = jwtService.getJwtRefreshFromCookies(request);
//
//        if ((refreshToken != null) && (refreshToken.length() > 0)) {
//            return authService.refreshToken(refreshToken)
//                    .map(user -> {
//                        ResponseCookie jwtCookie = jwtService.generateJwtCookie(user);
//
//                        return ResponseEntity.ok()
//                                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
//                                .body(ResponseDto
//                                        .builder()
//                                        .status(HttpStatus.OK)
//                                        .success(true)
//                                        .message("Token is refreshed successfully!")
//                                        .build()
//                                );
//                    })
//                    .orElseThrow(() -> new TokenRefreshException(refreshToken, "Refresh token is not in database!"));
//        }
//
//        return ResponseEntity.badRequest()
//                .body(ResponseDto
//                        .builder()
//                        .status(HttpStatus.BAD_REQUEST)
//                        .success(false)
//                        .message("Refresh Token is empty!")
//                        .build()
//                );
//    }
}