package com.munchkin.product.dao;

import com.munchkin.product.dto.BrandDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandDaoImpl implements BrandDao {

    private static final String NAMESPACE = "com.munchkin.product.dao.BrandDao.";

    private SqlSession sqlSession;

    public BrandDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<BrandDto> getAll() {
        return sqlSession.selectList(NAMESPACE + "getAll");
    }
}
