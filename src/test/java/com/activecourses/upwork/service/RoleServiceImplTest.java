package com.activecourses.upwork.service;

import com.activecourses.upwork.model.Role;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.repository.role.RoleRepository;
import com.activecourses.upwork.repository.user.UserRepository;
import com.activecourses.upwork.service.role.RoleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RoleServiceImplTest {

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RoleServiceImpl roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addRole() {
        Role role = new Role();
        role.setName("ROLE_TEST");

        when(roleRepository.save(any(Role.class))).thenReturn(role);

        Role createdRole = roleService.addRole(role);

        assertNotNull(createdRole);
        assertEquals("ROLE_TEST", createdRole.getName());
    }

    @Test
    void removeRole() {
        int roleId = 1;

        Role role = new Role();
        role.setId(roleId);

        when(roleRepository.findById(roleId)).thenReturn(Optional.of(role));

        boolean success = roleService.removeRole(roleId);

        assertTrue(success);
        verify(roleRepository, times(1)).delete(role);
    }

    @Test
    void updateRole() {
        int roleId = 1;

        Role role = new Role();
        role.setId(roleId);
        role.setName("ROLE_OLD");

        Role updatedRole = new Role();
        updatedRole.setName("ROLE_NEW");

        when(roleRepository.findById(roleId)).thenReturn(Optional.of(role));
        when(roleRepository.save(any(Role.class))).thenReturn(updatedRole);

        Role result = roleService.updateRole(roleId, updatedRole);

        assertNotNull(result);
        assertEquals("ROLE_NEW", result.getName());
    }

    @Test
    void getAllRoles() {
        Role role1 = new Role();
        role1.setName("ROLE_1");

        Role role2 = new Role();
        role2.setName("ROLE_2");

        List<Role> roles = List.of(role1, role2);

        when(roleRepository.findAll()).thenReturn(roles);

        List<Role> result = roleService.getAllRoles();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(role1));
        assertTrue(result.contains(role2));
    }

    @Test
    void assignRolesToUser() {
        int userId = 1;
        Map<String, Object> roles = new HashMap<>();
        roles.put("roles", Arrays.asList("ROLE_ADMIN", "ROLE_USER")); // Updated to use a list of role names

        User user = new User();
        user.setId(userId);

        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");

        Role userRole = new Role();
        userRole.setName("ROLE_USER");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(roleRepository.findByName("ROLE_ADMIN")).thenReturn(Optional.of(adminRole));
        when(roleRepository.findByName("ROLE_USER")).thenReturn(Optional.of(userRole));

        boolean success = roleService.assignRolesToUser(userId, roles);

        assertTrue(success);
        assertEquals(2, user.getRoles().size());
        assertTrue(user.getRoles().contains(adminRole));
        assertTrue(user.getRoles().contains(userRole));
    }

}
