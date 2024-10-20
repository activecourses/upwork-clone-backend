package com.activecourses.upwork.service;

import com.activecourses.upwork.dto.user.UserDto;
import com.activecourses.upwork.dto.user.UserResponseDto;
import com.activecourses.upwork.mapper.user.UserDtoMapper;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.repository.user.UserRepository;
import com.activecourses.upwork.service.user.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserDtoMapper userDtoMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsers() {
        User user1 = new User();
        user1.setId(1);
        user1.setEmail("user1@example.com");

        User user2 = new User();
        user2.setId(2);
        user2.setEmail("user2@example.com");

        List<User> users = List.of(user1, user2);
        Page<User> pagedResult = new PageImpl<>(users);

        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());

        when(userRepository.findAll(any(Pageable.class))).thenReturn(pagedResult);

        UserDto userDto1 = new UserDto();
        userDto1.setId(1);

        UserDto userDto2 = new UserDto();
        userDto2.setId(2);

        when(userDtoMapper.mapTo(user1)).thenReturn(userDto1);
        when(userDtoMapper.mapTo(user2)).thenReturn(userDto2);

        UserResponseDto userResponseDto = userService.getAllUsers(0, 10, "id", "asc");

        assertNotNull(userResponseDto);
        assertEquals(2, userResponseDto.getContent().size());
        assertEquals(1, userResponseDto.getContent().get(0).getId());
        assertEquals(2, userResponseDto.getContent().get(1).getId());
    }

    @Test
    void findByEmail() {
        String email = "user@example.com";
        User user = new User();
        user.setEmail(email);

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        User foundUser = userService.findByEmail(email);

        assertNotNull(foundUser);
        assertEquals(email, foundUser.getEmail());
    }

    @Test
    void findByEmail_UserNotFound() {
        String email = "user@example.com";

        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> userService.findByEmail(email));
    }
}
