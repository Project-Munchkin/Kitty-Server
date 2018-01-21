package com.munchkin.user.service;

import com.munchkin.user.enums.BodyType;
import com.munchkin.user.enums.Gender;

public interface UserService {

    void addUserInfo(Gender gender, BodyType bodyType, int height);
}
