package com.activecourses.upwork.dto;

import java.math.BigDecimal;
import java.util.Set;

import com.activecourses.upwork.model.JobType;

import lombok.Data;

@Data
public class JobDTO {
    private String title;
    private String description;
    private BigDecimal budget;
    private JobType jobType;
    private Set<Integer> skillIds;
}