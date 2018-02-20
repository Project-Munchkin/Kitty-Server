package com.munchkin.product.service;

import com.munchkin.product.dto.ProductDto;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Map<String, List<ProductDto>> getAllShirtsByBrand();
    List<ProductDto> getByCategory(ProductDto product);
}
