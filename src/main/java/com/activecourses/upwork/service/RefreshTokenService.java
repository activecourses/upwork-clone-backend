package com.activecourses.upwork.service;

import com.activecourses.upwork.config.security.jwt.JwtService;
import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.exception.TokenRefreshException;
import com.activecourses.upwork.model.RefreshToken;
import com.activecourses.upwork.repository.auth.RefreshTokenRepository;
import com.activecourses.upwork.repository.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;


import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {
    private static final Logger logger = LoggerFactory.getLogger(RefreshTokenService.class);

    @Value("${application.security.jwt.refresh-token.expiration}")
    private Long refreshTokenDurationMs;

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository,
                               UserRepository userRepository,
                               JwtService jwtService) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Transactional
    public ResponseEntity<ResponseDto> refreshToken(HttpServletRequest request) {
        String refreshToken = getRefreshTokenFromRequest(request);

        if (refreshToken != null && !refreshToken.isEmpty()) {
            RefreshToken refreshTokenEntity = getRefreshTokenEntity(refreshToken);
            verifyExpiration(refreshTokenEntity);

            // Delete all refresh tokens of the user
            deleteByUserId(refreshTokenEntity.getUser().getId());

            // Ensure the token is deleted before creating a new one
            if (refreshTokenRepository.findByToken(refreshToken).isPresent()) {
                return buildBadRequestResponse("Failed to delete existing refresh token.");
            }

            // Generate new refresh token
            RefreshToken newRefreshToken = createRefreshToken(refreshTokenEntity.getUser().getId());

            ResponseCookie jwtCookie = jwtService.generateJwtCookie(newRefreshToken.getUser());
            ResponseCookie refreshTokenCookie = jwtService.generateRefreshJwtCookie(newRefreshToken.getToken());

            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                    .header(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString())
                    .body(ResponseDto.builder()
                            .status(HttpStatus.OK)
                            .success(true)
                            .data("Token is refreshed successfully!")
                            .build());
        } else {
            return buildBadRequestResponse("Refresh Token is empty!");
        }
    }

    private String getRefreshTokenFromRequest(HttpServletRequest request) {
        return jwtService.getJwtRefreshFromCookies(request);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        return jwtService.getJwtFromCookies(request);
    }

    private RefreshToken getRefreshTokenEntity(String refreshToken) {
        return findByToken(refreshToken)
                .orElseThrow(() -> new TokenRefreshException(refreshToken, "Refresh token is not in database!"));
    }

    private ResponseEntity<ResponseDto> buildBadRequestResponse(String m) {
        return ResponseEntity.badRequest()
                .body(ResponseDto.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .success(false)
                        .data(m)
                        .build());
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(int userId) {
        // Delete all refresh tokens of the user (if any)
        int deletedCount = deleteByUserId(userId);

        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUser(userRepository.findById(userId).get());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    public void verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(),
                    "Refresh token was expired. "
                    + "Please sign in again to obtain a new refresh token.");
        }

    }

    public int deleteByUserId(int userId) {
        return refreshTokenRepository.deleteByUserId(userId);
    }
}