package com.munchkin.product.dao;

import com.munchkin.product.dto.CategoryDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    private static final String NAMESPACE = "com.munchkin.product.dao.CategoryDao.";

    private SqlSession sqlSession;

    public CategoryDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<CategoryDto> getAll() {
        return sqlSession.selectList(NAMESPACE + "getAll");
    }

    @Override
    public CategoryDto getByName(String name) {
        return sqlSession.selectOne(NAMESPACE + "getByName", name);
    }

    @Override
    public CategoryDto getByCode(int code) {
        return sqlSession.selectOne(NAMESPACE + "getByCode", code);
    }
}
