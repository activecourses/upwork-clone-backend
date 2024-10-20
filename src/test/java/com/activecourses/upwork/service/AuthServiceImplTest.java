package com.activecourses.upwork.service;

import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.dto.authentication.login.LoginRequestDto;
import com.activecourses.upwork.dto.authentication.registration.RegistrationRequestDto;
import com.activecourses.upwork.mapper.Mapper;
import com.activecourses.upwork.model.RefreshToken;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.repository.user.UserRepository;
import com.activecourses.upwork.repository.role.RoleRepository;
import com.activecourses.upwork.service.authentication.AuthServiceImpl;
import com.activecourses.upwork.config.security.jwt.JwtService;
import com.activecourses.upwork.config.security.CustomUserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.ResponseCookie;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AuthServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private Mapper<User, RegistrationRequestDto> userMapper;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private CustomUserDetailsService customUserDetailsService;

    @Mock
    private RefreshTokenService refreshTokenService;

    @InjectMocks
    private AuthServiceImpl authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser() {
        RegistrationRequestDto registrationRequestDto = new RegistrationRequestDto();
        registrationRequestDto.setFirstName("Ahmed");
        registrationRequestDto.setLastName("Muhammed");
        registrationRequestDto.setEmail("am0103738@gmail.com");
        registrationRequestDto.setPassword("password123");

        User user = new User();
        user.setFirstName("Ahmed");
        user.setLastName("Muhammed");
        user.setEmail("am0103738@gmail.com");
        user.setPassword("encodedPassword");

        when(userMapper.mapFrom(any(RegistrationRequestDto.class))).thenReturn(user);
        when(passwordEncoder.encode(any(String.class))).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userRepository.findByEmail("am0103738@gmail.com")).thenReturn(Optional.of(user));

        authService.registerUser(registrationRequestDto);

        verify(userRepository, times(1)).save(user);
        assertNotNull(userRepository.findByEmail("am0103738@gmail.com"));
        assertEquals("encodedPassword", user.getPassword());
    }

    @Test
    void login() {
        LoginRequestDto loginRequestDto = new LoginRequestDto("am0103738@gmail.com", "password123");

        User user = new User();
        user.setId(1);
        user.setEmail("am0103738@gmail.com");
        user.setPassword("encodedPassword");
        user.setAccountEnabled(true);
        user.setAccountLocked(false);

        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn(user.getEmail());
        when(userDetails.getPassword()).thenReturn(user.getPassword());

        when(userRepository.findByEmail("am0103738@gmail.com")).thenReturn(Optional.of(user));
        when(authenticationManager.authenticate(any(Authentication.class))).thenReturn(mock(Authentication.class));
        when(customUserDetailsService.loadUserByUsername("am0103738@gmail.com")).thenReturn(user);

        ResponseCookie jwtCookie = mock(ResponseCookie.class);
        when(jwtService.generateJwtCookie(any(UserDetails.class))).thenReturn(jwtCookie);

        RefreshToken refreshToken = mock(RefreshToken.class);
        when(refreshTokenService.createRefreshToken(anyInt())).thenReturn(refreshToken);
        when(refreshToken.getToken()).thenReturn("refreshToken");

        ResponseCookie refreshJwtCookie = mock(ResponseCookie.class);
        when(jwtService.generateRefreshJwtCookie(anyString())).thenReturn(refreshJwtCookie);

        ResponseDto responseDto = authService.login(loginRequestDto);

        assertEquals(HttpStatus.OK, responseDto.getStatus());
        assertTrue(responseDto.isSuccess());
    }

    @Test
    void logout() {
        User user = new User();
        user.setId(1);

        SecurityContextHolder.getContext().setAuthentication(mock(Authentication.class));
        when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(user);
        when(jwtService.getCleanJwtCookie()).thenReturn(mock(ResponseCookie.class));
        when(jwtService.getCleanJwtRefreshCookie()).thenReturn(mock(ResponseCookie.class));

        ResponseEntity<ResponseDto> responseEntity = authService.logout();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertTrue(Objects.requireNonNull(responseEntity.getBody()).isSuccess());
    }

    @Test
    void refreshToken() {
        String refreshToken = "refreshToken";
        User user = new User();
        user.setEmail("am0103738@gmail.com");

        when(jwtService.getUserNameFromJwtToken(refreshToken)).thenReturn("am0103738@gmail.com");
        when(userRepository.findByEmail("am0103738@gmail.com")).thenReturn(Optional.of(user));

        Optional<User> refreshedUser = authService.refreshToken(refreshToken);

        assertTrue(refreshedUser.isPresent());
        assertEquals("am0103738@gmail.com", refreshedUser.get().getEmail());
    }

    @Test
    void verifyUser() {
        String token = "verificationToken";
        User user = new User();
        user.setVerificationToken(token);

        when(userRepository.findByVerificationToken(token)).thenReturn(Optional.of(user));

        boolean isVerified = authService.verifyUser(token);

        assertTrue(isVerified);
        assertTrue(user.isAccountEnabled());
        assertNull(user.getVerificationToken());
    }

    @Test
    void findByEmail() {
        String email = "am0103738@gmail.com";
        User user = new User();
        user.setEmail(email);

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        User foundUser = authService.findByEmail(email);

        assertNotNull(foundUser);
        assertEquals(email, foundUser.getEmail());
    }

    @Test
    void sendVerificationEmail() {
        User user = new User();
        user.setEmail("am0103738@gmail.com");
        user.setVerificationToken("verificationToken");

        doNothing().when(mailSender).send(any(SimpleMailMessage.class));

        authService.sendVerificationEmail(user);

        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    void deactivateUser() {
        int userId = 1;
        User user = new User();
        user.setId(userId);
        user.setAccountEnabled(true);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        boolean success = authService.deactivateUser(userId);

        assertTrue(success);
        assertFalse(user.isAccountEnabled());
    }

    @Test
    void reactivateUser() {
        int userId = 1;
        User user = new User();
        user.setId(userId);
        user.setAccountEnabled(false);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        boolean success = authService.reactivateUser(userId);

        assertTrue(success);
        assertTrue(user.isAccountEnabled());
    }
}
