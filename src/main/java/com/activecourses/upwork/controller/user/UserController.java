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


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "User API")
public class UserController {

    private final UserService userService;

    // TODO: update it so than it can be sorted by multiple fields
    @Operation(summary = "Get all users",
            description = "Retrieve a paginated list of all users. Only accessible by users with the ROLE_ADMIN role.",
            parameters = {
                    @Parameter(name = "pageNo", in = ParameterIn.QUERY, description = "Page number", required = false, schema = @Schema(type = "integer", defaultValue = "0")),
                    @Parameter(name = "pageSize", in = ParameterIn.QUERY, description = "Page size", required = false, schema = @Schema(type = "integer", defaultValue = "10")),
                    @Parameter(name = "sortBy", in = ParameterIn.QUERY, description = "Sort by", required = false, schema = @Schema(type = "string", defaultValue = "id")),
                    @Parameter(name = "sortDir", in = ParameterIn.QUERY, description = "Sort direction", required = false, schema = @Schema(type = "string", defaultValue = "asc"))
            }
    )
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<ResponseDto> getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {
        UserResponseDto userResponseDto = userService.getAllUsers(pageNo, pageSize, sortBy, sortDir);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto.
                        builder()
                        .data(userResponseDto)
                        .success(true)
                        .status(HttpStatus.OK)
                        .build());
    }

}