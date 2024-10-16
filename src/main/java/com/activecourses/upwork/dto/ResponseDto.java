package com.activecourses.upwork.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class ResponseDto {
    private HttpStatus status;
    private boolean success;
    private Object data;
    private Object error;
}
