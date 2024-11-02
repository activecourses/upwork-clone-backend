package com.activecourses.upwork.controller.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.activecourses.upwork.dto.JobDTO;
import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.mapper.JobMapper;
import com.activecourses.upwork.model.Job;
import com.activecourses.upwork.service.job.JobService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Job", description = "Job Management API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs/")
public class JobController {
    private final JobService jobService;
    private final JobMapper jobMapper;

    @Operation(
            summary = "Create a new job",
            description = "Creates a new job posting",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT') or hasRole('FREELANCER')")
    @PostMapping("/post")
    public ResponseEntity<ResponseDto> createJob(@RequestBody JobDTO jobDTO) {
        Job createdJob = jobService.createJob(jobDTO);
        return buildResponseEntity(HttpStatus.CREATED, true, jobMapper.mapTo(createdJob), null);
    }

    private ResponseEntity<ResponseDto> buildResponseEntity(
            HttpStatus status, boolean success, Object data, Object error) {
        return ResponseEntity
                .status(status)
                .body(ResponseDto
                        .builder()
                        .status(status)
                        .success(success)
                        .data(data)
                        .error(error)
                        .build()
                );
    }
}
