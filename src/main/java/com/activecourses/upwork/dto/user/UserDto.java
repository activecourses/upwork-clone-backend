package com.activecourses.upwork.dto.user;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isAccountLocked;
    private boolean isAccountEnabled;
    private List<String> roles;
    private LocalDateTime createdAt;
}
