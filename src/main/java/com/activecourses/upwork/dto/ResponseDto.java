package com.activecourses.upwork.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResponseDto {
    private HttpStatus status;
    private boolean success;
    private Object data;
    private Object error;
}
