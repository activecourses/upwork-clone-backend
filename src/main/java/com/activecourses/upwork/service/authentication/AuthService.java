package com.activecourses.upwork.service.authentication;

import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.dto.authentication.login.LoginRequestDto;
import com.activecourses.upwork.dto.authentication.registration.RegistrationRequestDto;
import com.activecourses.upwork.dto.authentication.registration.RegistrationResponseDto;
import com.activecourses.upwork.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface AuthService {
    RegistrationResponseDto registerUser(RegistrationRequestDto registrationRequestDto);
    ResponseDto login(LoginRequestDto loginRequestDto);

    ResponseEntity<?> logout();

    Optional<User> refreshToken(String refreshToken);

    boolean verifyUser(String token);
    User findByEmail(String email);
    void sendVerificationEmail(User user);
    boolean deactivateUser(int userId);

    boolean reactivateUser(int userId);

    Integer getCurrentUserId();
}
