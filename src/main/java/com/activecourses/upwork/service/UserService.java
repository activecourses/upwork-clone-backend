package com.activecourses.upwork.service;

import com.activecourses.upwork.dto.LoginRequestDto;
import com.activecourses.upwork.dto.LoginResponseDto;
import com.activecourses.upwork.model.User;

public interface UserService {
    void registerUser(User user);
    LoginResponseDto verify(LoginRequestDto loginRequestDto);
    boolean verifyUser(String token);
    User findByEmail(String email);
    void sendVerificationEmail(User user);
}
