package com.boot.novel.services;

import com.boot.novel.models.UserDto;
import com.boot.novel.models.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
