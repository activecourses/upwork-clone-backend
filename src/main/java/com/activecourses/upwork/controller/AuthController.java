package com.activecourses.upwork.controller;

import com.activecourses.upwork.dto.LoginRequestDto;
import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AuthController {
    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseDto
                            .builder()
                            .status(HttpStatus.OK)
                            .success(true)
                            .data(userService.verify(loginRequestDto))
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
}
