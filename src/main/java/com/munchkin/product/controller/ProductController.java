package com.munchkin.product.controller;

import com.munchkin.dto.MuchfitError;
import com.munchkin.dto.MuchfitResponse;
import com.munchkin.product.dto.ProductDto;
import com.munchkin.product.service.ProductService;
import com.munchkin.user.dto.UserDto;
import com.munchkin.user.enums.Gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/match")
    public ResponseEntity<Object> match(@ModelAttribute UserDto user, @RequestParam int category,
    		@RequestParam String brandName) {
        MuchfitResponse response = new MuchfitResponse();
        ProductDto product = new ProductDto();
        product.setGender(user.getGender());
        product.setCategory(category);
        product.setBrandName(brandName);
        String resultSize = user.getSize();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("size", resultSize);
            product.setSize(resultSize);
            data.put("productInfo", productService.getByCategory(product));
            response.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            MuchfitError error = new MuchfitError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return new ResponseEntity<>(new MuchfitResponse(error), response.getError().getStatus());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
