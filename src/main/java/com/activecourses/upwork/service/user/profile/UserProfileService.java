package com.activecourses.upwork.service.user.profile;

import com.activecourses.upwork.dto.user.UserProfileDto;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.model.UserProfile;
import org.springframework.http.ResponseEntity;

public interface UserProfileService {
    ResponseEntity<?> getUserProfile(int id);

    UserProfile createUserProfile(User user);

    ResponseEntity<?> UpdateUserProfile(int userId, UserProfileDto updateRequest);
}
