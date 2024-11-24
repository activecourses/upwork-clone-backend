package com.activecourses.upwork.service.role;

import com.activecourses.upwork.model.Role;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.repository.role.RoleRepository;
import com.activecourses.upwork.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public boolean removeRole(int roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        if (role.isPresent()) {
            roleRepository.delete(role.get());
            return true;
        }
        return false;
    }

    @Override
    public Role updateRole(int roleId, Role role) {
        Optional<Role> existingRole = roleRepository.findById(roleId);
        if (existingRole.isPresent()) {
            Role updatedRole = existingRole.get();
            updatedRole.setName(role.getName());
            return roleRepository.save(updatedRole);
        }
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public boolean assignRolesToUser(int userId, Map<String, Object> roles) {
        logger.info("Assigning roles to user with id: {}", userId);
        Optional<User> user = userRepository.findById(userId);
        User unwrappedUser = user.orElseThrow(() -> new RuntimeException("User not found: " + userId));

        // Extract role names from the request body
        List<String> roleNames = (List<String>) roles.get("roles");

        // Fetch roles from the database
        List<Role> roleList = roleNames.stream()
                .map(roleName -> roleRepository.findByName(roleName)
                        .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
                .collect(Collectors.toList());

        // Assign roles to the user
        unwrappedUser.setRoles(roleList);
        userRepository.save(unwrappedUser);
        return true;
    }
}
