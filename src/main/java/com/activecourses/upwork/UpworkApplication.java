package com.activecourses.upwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UpworkApplication {
    public static void main(String[] args) {
        SpringApplication.run(UpworkApplication.class, args);
    }
}
