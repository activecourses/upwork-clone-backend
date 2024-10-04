package com.activecourses.upwork.service.user;

import com.activecourses.upwork.dto.user.UserResponseDto;


public interface UserService {
    UserResponseDto getAllUsers(int pageNo, int pageSize);
}
