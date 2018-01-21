package com.munchkin.user.service;

import com.munchkin.user.dao.UserDao;
import com.munchkin.user.domain.User;
import com.munchkin.user.enums.BodyType;
import com.munchkin.user.enums.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUserInfo(Gender gender, BodyType bodyType, int height) {
        userDao.add(new User(gender, bodyType, height));
    }
}
