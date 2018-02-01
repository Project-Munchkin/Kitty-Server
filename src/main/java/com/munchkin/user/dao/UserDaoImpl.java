package com.munchkin.user.dao;

import com.munchkin.user.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static String NAMESPACE = "com.munchkin.dao.UserDao.";

    private final SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void add(UserDto userDto) {
        sqlSession.insert(NAMESPACE + "add", userDto);
    }

    @Override
    public List<UserDto> getAll() {
        return sqlSession.selectList(NAMESPACE + "getAll");
    }

    @Override
    public void removeAll() {
        sqlSession.delete(NAMESPACE + "removeAll");
    }
}
