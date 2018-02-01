package com.munchkin.product.dao;

import com.munchkin.product.dto.ProductDto;

import java.util.List;

public interface ProductDao {

    List<ProductDto> getByCategory(ProductDto product);
}
