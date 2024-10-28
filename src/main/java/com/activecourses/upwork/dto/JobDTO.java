package com.activecourses.upwork.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.activecourses.upwork.model.JobStatus;
import com.activecourses.upwork.model.JobType;

import lombok.Data;

@Data
public class JobDTO {
    private Integer jobId;
    private String title;
    private String description;
    private BigDecimal budget;
    private JobType jobType;
    private JobStatus status;
    private LocalDateTime createdAt;
}