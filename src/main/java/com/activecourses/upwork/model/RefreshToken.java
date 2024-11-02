package com.activecourses.upwork.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "refresh_tokens")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Override
    public String toString() {
        return "RefreshToken{"
               + "id=" + id
               + ", token='" + token + '\''
               + ", expiryDate=" + expiryDate
               + '}';
    }
}