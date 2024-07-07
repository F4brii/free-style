package com.proyectofinal.freestyle.service;

import com.proyectofinal.freestyle.dto.UserDto;
import com.proyectofinal.freestyle.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
