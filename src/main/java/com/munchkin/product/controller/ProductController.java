package com.munchkin.product.controller;

import com.munchkin.dto.MuchfitError;
import com.munchkin.dto.MuchfitResponse;
import com.munchkin.user.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/match")
    public ResponseEntity<Object> match(@ModelAttribute UserDto user) {
        MuchfitResponse response = new MuchfitResponse();

        try {
            Map<String, Object> data = new HashMap<>();
            data.put("size", user.getSize());
            response.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            MuchfitError error = new MuchfitError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return new ResponseEntity<>(new MuchfitResponse(error), response.getError().getStatus());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
