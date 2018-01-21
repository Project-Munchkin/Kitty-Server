package com.munchkin.user.dao;

import com.munchkin.user.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void add(User user) {
        sqlSession.insert(NAMESPACE + "add", user);
    }

    @Override
    public List<User> getAll() {
        return sqlSession.selectList(NAMESPACE + "getAll");
    }

    @Override
    public void removeAll() {
        sqlSession.delete(NAMESPACE + "removeAll");
    }
}
