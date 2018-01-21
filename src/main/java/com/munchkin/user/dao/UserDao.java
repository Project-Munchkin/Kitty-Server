package com.munchkin.user.dao;

import com.munchkin.user.domain.User;

import java.util.List;

public interface UserDao {

    String NAMESPACE = "com.munchkin.dao.UserDao.";

    void add(User user);

    List<User> getAll();

    void removeAll();
}
