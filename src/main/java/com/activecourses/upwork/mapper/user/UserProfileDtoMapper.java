package com.activecourses.upwork.mapper.user;

import com.activecourses.upwork.dto.user.UserProfileDto;
import com.activecourses.upwork.mapper.Mapper;
import com.activecourses.upwork.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserProfileDtoMapper implements Mapper<User, UserProfileDto> {
    @Override
    public UserProfileDto mapTo(User user) {
        return UserProfileDto.builder()
                .id(user.getId())
                .title(user.getUserProfile().getTitle())
                .description(user.getUserProfile().getDescription())
                .hourlyRate(user.getUserProfile().getHourlyRate())
                .location(user.getUserProfile().getLocation())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    @Override
    public User mapFrom(UserProfileDto userProfileDto) {
        return null;
    }

}
