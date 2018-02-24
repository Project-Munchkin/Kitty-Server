package com.munchkin.product.dao;

import com.munchkin.product.dto.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private static final String NAMESPACE = "com.munchkin.product.dao.ProductDao.";

    private SqlSession sqlSession;

    public ProductDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<ProductDto> getByCategory(ProductDto product) {
        return sqlSession.selectList(NAMESPACE + "getByCategory", product);
    }
    
    @Override
    public String now() {
    	return sqlSession.selectOne(NAMESPACE + "now");
    }
}
