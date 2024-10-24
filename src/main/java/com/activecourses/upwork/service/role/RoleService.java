package com.activecourses.upwork.service.role;

import com.activecourses.upwork.model.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    Role addRole(Role role);

    boolean removeRole(int roleId);

    Role updateRole(int roleId, Role role);

    List<Role> getAllRoles();

    boolean assignRolesToUser(int userId, Map<String, Object> roles);
}
