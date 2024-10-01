package com.activecourses.upwork.service;

import com.activecourses.upwork.dto.LoginRequestDto;
import com.activecourses.upwork.dto.LoginResponseDto;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.repository.UserRepository;
import com.activecourses.upwork.config.security.JwtService;

import lombok.RequiredArgsConstructor;
import java.util.Optional;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final JavaMailSender mailSender;

    @Override
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public LoginResponseDto verify(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));

        User user = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new BadCredentialsException(""));
        String accessToken = jwtService.generateAccessToken(user.getUsername());
        String refreshToken = jwtService.generateRefreshToken(user.getUsername());

        return LoginResponseDto
                .builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public boolean verifyUser(String token) {
        Optional<User> user = userRepository.findByVerificationToken(token);
        User unwrappedUser = unwrapUser(user);
        if (unwrappedUser != null) {
            unwrappedUser.setAccountEnabled(true);
            unwrappedUser.setVerificationToken(null); // Clear the token
            userRepository.save(unwrappedUser);
            return true;
        }
        return false;
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return unwrapUser(user);
    }

    @Override
    public void sendVerificationEmail(User user) {
        String verificationLink = "http://localhost:8080/api/users/verify?token=" + user.getVerificationToken();
        
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Email Verification");
        message.setText("Click the link to verify your email: " + verificationLink);
        mailSender.send(message);
    }

    static User unwrapUser(Optional<User> entity) {
        if (entity.isPresent()) return entity.get();
        else throw new UnsupportedOperationException("Unimplemented method 'unwrapUser'");
    }
}
