package com.activecourses.upwork.controller.user;

import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.dto.user.UserResponseDto;
import com.activecourses.upwork.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "User API")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Get all users",
            description = "Retrieve a paginated list of all users. Only accessible by users with the ROLE_ADMIN role.",
            parameters = {
                    @Parameter(name = "pageNo", in = ParameterIn.QUERY, description = "Page number", required = false, schema = @Schema(type = "integer", defaultValue = "0")),
                    @Parameter(name = "pageSize", in = ParameterIn.QUERY, description = "Page size", required = false, schema = @Schema(type = "integer", defaultValue = "10"))
            }
    )
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<ResponseDto> getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        List<UserResponseDto> users = userService.getAllUsers(pageNo, pageSize);
        return ResponseEntity.ok(
                ResponseDto
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(users)
                        .build());
    }
}