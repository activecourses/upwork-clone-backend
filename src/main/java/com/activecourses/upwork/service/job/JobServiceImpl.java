package com.activecourses.upwork.service.job;

import org.springframework.stereotype.Service;

import com.activecourses.upwork.dto.JobDTO;
import com.activecourses.upwork.mapper.JobMapper;
import com.activecourses.upwork.model.Job;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.repository.job.JobRepository;
import com.activecourses.upwork.repository.user.UserRepository;
import com.activecourses.upwork.service.authentication.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private JobMapper jobMapper;

    @Override
    public Job createJob(JobDTO jobDTO) {
        int clientId = authService.getCurrentUserId();
        User client = userRepository.findById(clientId).orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobMapper.mapFrom(jobDTO);
        job.setClient(client);

        return jobRepository.save(job);
    }
}
