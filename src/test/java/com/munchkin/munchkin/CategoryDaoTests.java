package com.munchkin.munchkin;

import com.munchkin.product.dao.CategoryDao;
import com.munchkin.product.dto.CategoryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryDaoTests {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void getByName() {
        CategoryDto categoryDto = categoryDao.getByName("셔츠");
        assertEquals(categoryDto.getCode(), 3);
    }

    @Test
    public void getByCode() {
        CategoryDto categoryDto = categoryDao.getByCode(3);
        assertEquals(categoryDto.getName(), "셔츠");
    }
}
