package com.activecourses.upwork.controller.role;

import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.model.Role;
import com.activecourses.upwork.service.role.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "Role", description = "Role Management API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roles/")
public class RoleController {
    private final RoleService roleService;
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Operation(
            summary = "Add a new role",
            description = "Add a new role, accessible only by admins",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addRole(@RequestBody Role role) {
        logger.info("Adding new role: {}", role.getName());
        Role createdRole = roleService.addRole(role);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ResponseDto
                        .builder()
                        .status(HttpStatus.CREATED)
                        .success(true)
                        .data(createdRole)
                        .build()
                );
    }

    @Operation(
            summary = "Remove a role",
            description = "Remove a role, accessible only by admins",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/remove/{roleId}")
    public ResponseEntity<ResponseDto> removeRole(@PathVariable int roleId) {
        logger.info("Removing role with id: {}", roleId);
        boolean success = roleService.removeRole(roleId);
        return success
                ? ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data("Role removed successfully.")
                        .build()
                )
                : ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ResponseDto
                        .builder()
                        .status(HttpStatus.NOT_FOUND)
                        .success(false)
                        .error("Role not found.")
                        .build()
                );
    }

    @Operation(
            summary = "Update a role",
            description = "Update a role, accessible only by admins",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{roleId}")
    public ResponseEntity<ResponseDto> updateRole(@PathVariable int roleId, @RequestBody Role role) {
        logger.info("Updating role with id: {}", roleId);
        Role updatedRole = roleService.updateRole(roleId, role);
        if (updatedRole != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseDto
                            .builder()
                            .status(HttpStatus.OK)
                            .success(true)
                            .data(updatedRole)
                            .build()
                    );
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ResponseDto
                            .builder()
                            .status(HttpStatus.NOT_FOUND)
                            .success(false)
                            .error("Role not found.")
                            .build()
                    );
        }
    }

    @Operation(
            summary = "Get all roles",
            description = "Retrieve a list of all roles, accessible only by admins",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<ResponseDto> getAllRoles() {
        logger.info("Retrieving all roles");
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(roles)
                        .build()
                );
    }

    @Operation(
            summary = "Assign roles to users",
            description = "Assign roles to users, accessible only by admins",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/assign-roles")
    public ResponseDto assignRolesToUser(@PathVariable int id, @RequestBody Map<String, Object> roles) {
        logger.info("Assigning roles to user with id: {}", id);
        boolean success = roleService.assignRolesToUser(id, roles);
        if (success) {
            return ResponseDto.builder()
                    .status(HttpStatus.OK)
                    .success(true)
                    .data("Roles assigned successfully.")
                    .build();
        } else {
            return ResponseDto.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .success(false)
                    .error("User not found.")
                    .build();
        }
    }
}
