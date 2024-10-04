package com.activecourses.upwork.service.user;

import com.activecourses.upwork.dto.user.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers(int pageNo, int pageSize);
}
