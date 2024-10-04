package com.activecourses.upwork.repository.user;

import com.activecourses.upwork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findById(int id);
    Optional<User> findByVerificationToken(String token);
}