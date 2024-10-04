package com.activecourses.upwork.mapper.user;

import com.activecourses.upwork.dto.authentication.registration.RegistrationRequestDto;
import com.activecourses.upwork.exception.AuthenticationException;
import com.activecourses.upwork.mapper.Mapper;
import com.activecourses.upwork.model.Role;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.repository.role.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserRegistrationMapper implements Mapper<User, RegistrationRequestDto> {

    private final RoleRepository roleRepository;

    @Override
    public RegistrationRequestDto mapTo(User user) {
        return RegistrationRequestDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public User mapFrom(RegistrationRequestDto registrationRequestDto) {
        return User.builder()
                .firstName(registrationRequestDto.getFirstName())
                .lastName(registrationRequestDto.getLastName())
                .email(registrationRequestDto.getEmail())
                .password(registrationRequestDto.getPassword())
                .roles(mapRoles(registrationRequestDto.getRoles()))
                .build();
    }

    private List<Role> mapRoles(List<String> roles) {
        return roles.stream()
                .map(roleName -> roleRepository.findByName(roleName)
                        .orElseThrow(() -> new AuthenticationException("Role not found: " + roleName)))
                .collect(Collectors.toList());
    }
}
