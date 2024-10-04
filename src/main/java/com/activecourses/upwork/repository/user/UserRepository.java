package com.activecourses.upwork.repository.user;

import com.activecourses.upwork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    Optional<User> findByVerificationToken(String token);
}