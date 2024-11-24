package com.activecourses.upwork.repository.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.activecourses.upwork.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    
}