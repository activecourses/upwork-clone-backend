package com.activecourses.upwork.mapper;

import org.springframework.stereotype.Component;

import com.activecourses.upwork.dto.JobDTO;
import com.activecourses.upwork.model.Job;
import com.activecourses.upwork.model.JobStatus;

@Component
public class JobMapper implements Mapper<Job, JobDTO> {

    @Override
    public JobDTO mapTo(Job job) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setBudget(job.getBudget());
        jobDTO.setJobType(job.getJobType());
        return jobDTO;
    }

    @Override
    public Job mapFrom(JobDTO jobDTO) {
        Job job = new Job();
        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setBudget(jobDTO.getBudget());
        job.setJobType(jobDTO.getJobType());
        job.setStatus(JobStatus.Open); // Default status
        return job;
    }
}
