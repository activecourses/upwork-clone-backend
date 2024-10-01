package com.activecourses.upwork.config.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private long jwtExpirationTime;
    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshJwtExpirationTime;

    public String generateAccessToken(String username) {
        return generateToken(username, jwtExpirationTime);
    }
    public String generateRefreshToken(String username){
        return generateToken(username, refreshJwtExpirationTime);
    }
    public String generateToken(String username, long expirationTime) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getKey())
                .compact();
    }
    private Key getKey() {
        byte[] keyBytes = secretKey.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
