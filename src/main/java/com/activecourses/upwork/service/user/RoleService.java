package com.activecourses.upwork.service.user;

import com.activecourses.upwork.model.Role;

import java.util.List;

public interface RoleService {
    Role addRole(Role role);
    boolean removeRole(int roleId);
    Role updateRole(int roleId, Role role);
    List<Role> getAllRoles();
}
