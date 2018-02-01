package com.munchkin.user.dao;

import com.munchkin.user.dto.UserDto;

import java.util.List;

public interface UserDao {

    void add(UserDto userDto);

    List<UserDto> getAll();

    void removeAll();
}
