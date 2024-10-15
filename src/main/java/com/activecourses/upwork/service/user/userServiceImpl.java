package com.activecourses.upwork.service.user;

import com.activecourses.upwork.dto.user.UserDto;
import com.activecourses.upwork.dto.user.UserResponseDto;
import com.activecourses.upwork.mapper.user.UserDtoMapper;
import com.activecourses.upwork.model.User;
import com.activecourses.upwork.repository.user.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class userServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    public userServiceImpl(UserRepository userRepository, UserDtoMapper userDtoMapper) {
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public UserResponseDto getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir) {
        // Set the sorting direction
        // ascending or descending (ASC or DESC)
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // Create a Pageable object with the requested page number, page size, and sort
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        // Retrieve a page of users
        Page<User> pagedResult = userRepository.findAll(pageable);

        // Get the content
        List<User> users = pagedResult.getContent();

        List<UserDto> content = users.stream()
                .map(userDtoMapper::mapTo)
                .toList();

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setContent(content);
        userResponseDto.setPageNo(pagedResult.getNumber());
        userResponseDto.setPageSize(pagedResult.getSize());
        userResponseDto.setTotalElements((int) pagedResult.getTotalElements());
        userResponseDto.setTotalPages(pagedResult.getTotalPages());
        userResponseDto.setLast(pagedResult.isLast());
        return userResponseDto;


    }
    public String deleteUserbyId(Integer id){
        if ( !userRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
}
