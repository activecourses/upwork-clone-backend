package com.activecourses.upwork.service.user;

import com.activecourses.upwork.dto.user.UserResponseDto;
import com.activecourses.upwork.mapper.user.UserResponseMapper;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.repository.user.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class userServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserResponseMapper userResponseMapper;

    public userServiceImpl(UserRepository userRepository, UserResponseMapper userResponseMapper) {
        this.userRepository = userRepository;
        this.userResponseMapper = userResponseMapper;
    }

    @Override
    public List<UserResponseDto> getAllUsers(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        // Retrieve a page of users
        Page<User> pagedResult = userRepository.findAll(pageable);

        // Get the content
        List<User> users = pagedResult.getContent();

        return users.stream()
                .map(userResponseMapper::mapTo)
                .collect(Collectors.toList());
    }
}
