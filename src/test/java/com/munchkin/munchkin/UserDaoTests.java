package com.munchkin.munchkin;

import com.munchkin.user.dao.UserDao;
import com.munchkin.user.dto.UserDto;
import com.munchkin.user.enums.Arm;
import com.munchkin.user.enums.BodyType;
import com.munchkin.user.enums.Gender;
import com.munchkin.user.enums.Shoulder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserDaoTests {

    @Autowired
    private UserDao userDao;

    private List<UserDto> userDtoList;

    @Before
    public void setup() {
        userDtoList = Arrays.asList(new UserDto(Gender.MAN, BodyType.NORMAL, 182, Shoulder.NARROW, Arm.LONG),
                new UserDto(Gender.WOMAN, BodyType.THIN, 158, Shoulder.NARROW, Arm.NORMAL));
        userDao.removeAll();
    }

    @Test
    public void add() {
        for (UserDto userDto : userDtoList) {
            userDao.add(userDto);
        }

        List<UserDto> addedUserDtoList = userDao.getAll();

        assertEquals(userDtoList.size(), addedUserDtoList.size());

        for (int i = 0; i < userDtoList.size(); i++) {
            assertEquals(userDtoList.get(i).getGender().getValue(), addedUserDtoList.get(i).getGender().getValue());
            assertEquals(userDtoList.get(i).getBodyType().getValue(), addedUserDtoList.get(i).getBodyType().getValue());
            assertEquals(userDtoList.get(i).getHeight(), addedUserDtoList.get(i).getHeight());
        }
    }
}
