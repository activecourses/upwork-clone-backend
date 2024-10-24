package com.activecourses.upwork.service.user.profile;

import com.activecourses.upwork.dto.ResponseDto;
import com.activecourses.upwork.dto.user.UserProfileDto;
import com.activecourses.upwork.mapper.Mapper;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.model.UserProfile;
import com.activecourses.upwork.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImplUserProfileService implements UserProfileService {
    private final UserRepository userRepository;
    private final Mapper<User, UserProfileDto> userProfileMapper;

    @Override
    public ResponseEntity<?> getUserProfile(int id) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new UsernameNotFoundException("user Not Found"));
        UserProfileDto userProfileDto = userProfileMapper.mapTo(user);

        return ResponseEntity.ok()
                .body(ResponseDto.builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(userProfileDto)
                        .build());
    }

    public UserProfile createUserProfile(User user) {
        return UserProfile.builder()
                .user(user).build();
    }

    @Override
    public ResponseEntity<?> UpdateUserProfile(int userId, UserProfileDto updateRequest) {
        User user = userRepository.findById(updateRequest.getId()).
                orElseThrow(() -> new UsernameNotFoundException("user Not Found"));
        // Check if this user try to update another user profile
        if (userId != user.getId()) {
            throw new RuntimeException("this User can't update another user profile");
        }
        return ResponseEntity.ok()
                .body(ResponseDto.builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(doUpdate(updateRequest, user))
                        .build());
    }

    private UserProfileDto doUpdate(UserProfileDto updateRequest, User user) {
        // Update fields that in user table
        user.setFirstName(updateRequest.getFirstName());
        user.setLastName(updateRequest.getLastName());

        // Get userProfile and update it.
        UserProfile userProfile = user.getUserProfile();
        userProfile.setDescription(updateRequest.getDescription());
        userProfile.setLocation(updateRequest.getLocation());
        userProfile.setTitle(userProfile.getTitle());
        userProfile.setHourlyRate(updateRequest.getHourlyRate());

        // Update user in database
        user.setUserProfile(userProfile);
        userRepository.save(user);
        return updateRequest;
    }

}
