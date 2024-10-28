package com.activecourses.upwork.mapper;

import com.activecourses.upwork.dto.JobDTO;
import com.activecourses.upwork.model.Job;

public class JobMapper implements Mapper<Job, JobDTO> {

    @Override
    public JobDTO mapTo(Job job) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getJobId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setBudget(job.getBudget());
        jobDTO.setJobType(job.getJobType());
        jobDTO.setStatus(job.getStatus());
        jobDTO.setCreatedAt(job.getCreatedAt());
        return jobDTO;
    }

    @Override
    public Job mapFrom(JobDTO jobDTO) {
        Job job = new Job();
        job.setJobId(jobDTO.getId());
        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setBudget(jobDTO.getBudget());
        job.setJobType(jobDTO.getJobType());
        job.setStatus(jobDTO.getStatus());
        job.setCreatedAt(jobDTO.getCreatedAt());
        return job;
    }
}
