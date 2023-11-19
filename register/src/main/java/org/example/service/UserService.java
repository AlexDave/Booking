package org.example.service;

import java.util.List;
import org.example.dto.UserDto;
import org.example.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}