package com.activecourses.upwork.service.job;

import com.activecourses.upwork.dto.JobDTO;
import com.activecourses.upwork.model.Job;

public interface JobService {
    Job createJob(JobDTO jobDTO);
}
