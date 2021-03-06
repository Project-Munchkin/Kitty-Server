package com.munchkin.user.service;

import com.munchkin.user.dao.UserDao;
import com.munchkin.user.dto.UserDto;
import com.munchkin.user.enums.Arm;
import com.munchkin.user.enums.BodyType;
import com.munchkin.user.enums.Gender;
import com.munchkin.user.enums.Shoulder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUserInfo(Gender gender, BodyType bodyType, int height, Shoulder shoulder, Arm arm) {
        userDao.add(new UserDto(gender, bodyType, height, shoulder, arm));
    }
}
