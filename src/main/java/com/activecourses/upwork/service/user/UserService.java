package com.activecourses.upwork.service.user;

import com.activecourses.upwork.dto.user.UserResponseDto;


public interface UserService {
    String deleteUserbyId(Integer id);
    UserResponseDto getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);
}
