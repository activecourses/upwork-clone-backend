package com.activecourses.upwork.mapper.user;

import com.activecourses.upwork.dto.user.UserResponseDto;
import com.activecourses.upwork.mapper.Mapper;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.model.Role;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserResponseMapper implements Mapper<User, UserResponseDto> {
    @Override
    public UserResponseDto mapTo(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .roles(user.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.toList()))
                .isAccountLocked(user.isAccountLocked())
                .isAccountEnabled(user.isAccountEnabled())
                .createdAt(user.getCreatedAt())
                .build();
    }

    @Override
    public User mapFrom(UserResponseDto userResponseDto) {
        throw new UnsupportedOperationException(); // Not needed
    }
}
