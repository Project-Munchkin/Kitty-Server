package com.munchkin.munchkin;

import com.munchkin.user.dao.UserDao;
import com.munchkin.user.domain.User;
import com.munchkin.user.enums.BodyType;
import com.munchkin.user.enums.Gender;
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

    private List<User> users;

    @Before
    public void setup() {
        users = Arrays.asList(new User(Gender.MAN, BodyType.NORMAL, 182),
                new User(Gender.WOMAN, BodyType.THIN, 158));
        userDao.removeAll();
    }

    @Test
    public void add() {
        for (User user : users) {
            userDao.add(user);
        }

        List<User> addedUsers = userDao.getAll();

        assertEquals(users.size(), addedUsers.size());

        for (int i = 0; i < users.size(); i++) {
            assertEquals(users.get(i).getGender().getValue(), addedUsers.get(i).getGender().getValue());
            assertEquals(users.get(i).getBodyType().getValue(), addedUsers.get(i).getBodyType().getValue());
            assertEquals(users.get(i).getHeight(), addedUsers.get(i).getHeight());
        }
    }
}
