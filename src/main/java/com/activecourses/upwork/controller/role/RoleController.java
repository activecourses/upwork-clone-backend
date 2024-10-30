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
        return buildResponseEntity(HttpStatus.CREATED, true, createdRole, null);
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
                ? buildResponseEntity(HttpStatus.OK, true, "Role removed successfully.", null)
                : buildResponseEntity(HttpStatus.NOT_FOUND, false, null, "Role not found.");
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
        return updatedRole != null
                ? buildResponseEntity(HttpStatus.OK, true, updatedRole, null)
                : buildResponseEntity(HttpStatus.NOT_FOUND, false, null, "Role not found.");
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
        return buildResponseEntity(HttpStatus.OK, true, roles, null);
    }

    @Operation(
            summary = "Assign roles to users",
            description = "Assign roles to users, accessible only by admins",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/assign-roles")
    public ResponseEntity<ResponseDto> assignRolesToUser(@PathVariable int id, @RequestBody Map<String, Object> roles) {
        logger.info("Assigning roles to user with id: {}", id);
        boolean success = roleService.assignRolesToUser(id, roles);
        return success
                ? buildResponseEntity(HttpStatus.OK, true, "Roles assigned successfully.", null)
                : buildResponseEntity(HttpStatus.NOT_FOUND, false, null, "User not found.");
    }

    private ResponseEntity<ResponseDto> buildResponseEntity(HttpStatus status,
                                                            boolean success,
                                                            Object data,
                                                            Object error) {
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
