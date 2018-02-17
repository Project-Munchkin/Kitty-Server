package com.munchkin.user.service;

import com.munchkin.user.enums.Arm;
import com.munchkin.user.enums.BodyType;
import com.munchkin.user.enums.Gender;
import com.munchkin.user.enums.Shoulder;

public interface UserService {

    void addUserInfo(Gender gender, BodyType bodyType, int height, Shoulder shoulder, Arm arm);
}
