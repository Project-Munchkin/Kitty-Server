package com.munchkin.product.service;

import com.munchkin.product.dao.BrandDao;
import com.munchkin.product.dao.CategoryDao;
import com.munchkin.product.dao.ProductDao;
import com.munchkin.product.dto.BrandDto;
import com.munchkin.product.dto.CategoryDto;
import com.munchkin.product.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Map<String, List<ProductDto>> getAllShirtsByBrand() {
        Map<String, List<ProductDto>> shirtsByBrand = new HashMap<>();

        List<BrandDto> brands = brandDao.getAll();
        CategoryDto category = categoryDao.getByName("셔츠");
        for (BrandDto brand : brands) {
            ProductDto product = new ProductDto();
            product.setBrandName(brand.getName());
            product.setCategory(category.getCode());

            List<ProductDto> products = productDao.getByCategory(product);
            shirtsByBrand.put(brand.getName(), products);
        }

        return shirtsByBrand;
    }
}
