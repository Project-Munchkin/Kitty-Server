package com.munchkin.product.dao;

import com.munchkin.product.dto.CategoryDto;

import java.util.List;

public interface CategoryDao {

    List<CategoryDto> getAll();

    CategoryDto getByName(String name);

    CategoryDto getByCode(int code);
}
