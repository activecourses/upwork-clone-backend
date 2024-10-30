package com.activecourses.upwork.controller.user;

import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.dto.user.UserProfileDto;
import com.activecourses.upwork.dto.user.UserResponseDto;
import com.activecourses.upwork.service.user.profile.UserProfileService;
import com.activecourses.upwork.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User", description = "User API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/")
public class UserController {
    private final UserService userService;
    private final UserProfileService userProfileService;

    // TODO: update it so than it can be sorted by multiple fields
    @Operation(summary = "Get all users",
            description = "Retrieve a paginated list of all users. Only accessible by users with the ROLE_ADMIN role.",
            parameters = {
                    @Parameter(name = "pageNo", in = ParameterIn.QUERY,
                            description = "Page number",
                            schema = @Schema(type = "integer", defaultValue = "0")),
                    @Parameter(name = "pageSize", in = ParameterIn.QUERY,
                            description = "Page size",
                            schema = @Schema(type = "integer", defaultValue = "10")),
                    @Parameter(name = "sortBy", in = ParameterIn.QUERY,
                            description = "Sort by",
                            schema = @Schema(type = "string", defaultValue = "id")),
                    @Parameter(name = "sortDir", in = ParameterIn.QUERY,
                            description = "Sort direction",
                            schema = @Schema(type = "string", defaultValue = "asc"))
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

    @Operation(summary = "Get User Profile",
            description = "Retrieve the profile information of the user specified by the userId.")
    @GetMapping("/profile/{userId}")
    public ResponseEntity<?> getUserProfile(@PathVariable int userId, HttpServletRequest httpRequest) {
        try {
            return userProfileService.getUserProfile(userId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDto.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .success(false)
                    .data(e.getMessage())
                    .build());
        }
    }

    @Operation(summary = "Update User Profile",
            description = "Update the profile information of the user specified by the userId")
    @PutMapping("/profile/{userId}")
    public ResponseEntity<?> updateUserProfile(
            @PathVariable int userId,
            @RequestBody @Valid UserProfileDto updateRequest) {
        try {
            return userProfileService.UpdateUserProfile(userId, updateRequest);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDto.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .success(false)
                    .data(e.getMessage())
                    .build());
        }

    }
}
