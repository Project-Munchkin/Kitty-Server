package com.munchkin.munchkin;

import com.munchkin.product.dto.ProductDto;
import com.munchkin.product.service.ProductService;
import com.munchkin.user.dto.UserDto;
import com.munchkin.user.enums.BodyType;
import com.munchkin.user.enums.Gender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatchingCalcTests {

    @Autowired
    private ProductService productService;

    private UserDto user;

    @Before
    public void setup() {
        user = new UserDto(Gender.MAN, BodyType.NORMAL, 174);
    }

    @Test
    public void match() {
    	//처음 미디움 사이즈 100으로 시작
    	int size = 100;
    	int height = 152;
    	int body_type = 2;
    	int shoulder = 1;
    	int arm = 1;
    	size = setWomanHeightSize(size, height);//키에따라 -8 or +8
    	size = setBodyTypeSize(size, body_type);//체형에따라 -6 or +6
    	size = setShoulderSize(size, shoulder);//어깨에따라 -4 or +4
    	size = setArmSize(size, arm);//팔길이에따라 -2 or +2

    	System.out.println("returnSize"+size);
    	String resultSize;
    	resultSize = matchingSize(size);
    	System.out.println(resultSize);
    }

    public int setWomanHeightSize(int size, int height) {

    	if (height < 150){
    		size = size - 24;
    	} else if (height >= 150 && height < 155) {
    		size = size - 16;
    	} else if (height >= 155 && height < 160) {
    		size = size - 8;
    	} else if (height >= 160 && height < 165) {
    		size = size ;
    	} else if (height >= 165 && height < 170) {
    		size = size + 8 ;
    	} else if (height >= 170 && height < 175) {
    		size = size + 16 ;
    	} else if (height >= 175) {
    		size = size + 24 ;
    	}
    	System.out.println("setWomanHeightSize"+size);
    	return size;
    }

    public int setBodyTypeSize (int size, int body_type) {
    	switch(body_type)
    	{
    	    case 1 : size = size - 6 ; break;
    	    case 2 : size = size; break;
    	    case 3 : size = size + 6; break;
    	}
    	System.out.println("setBodyTypeSize"+size);
    	return size;
    }

    public int setShoulderSize (int size, int shoulder) {
    	switch(shoulder)
    	{
    	    case 1 : size = size - 4 ; break;
    	    case 2 : size = size; break;
    	    case 3 : size = size + 4; break;
    	}
    	System.out.println("setShoulderSize"+size);
    	return size;
    }

    public int setArmSize (int size, int arm) {
    	switch(arm)
    	{
    	    case 1 : size = size - 2 ; break;
    	    case 2 : size = size; break;
    	    case 3 : size = size + 2; break;
    	}
    	System.out.println("setArmSize"+size);
    	return size;
    }

    public String matchingSize (int size) {
    	String matchingSize = null;
    	int xSmall = Math.abs(60 - size);
    	int small = Math.abs(80 - size);
    	int medium = Math.abs(100 - size);
    	int large = Math.abs(120 - size);
    	int xLarge = Math.abs(140 - size);
    	System.out.println(xSmall);
    	System.out.println(small);
    	System.out.println(medium);
    	System.out.println(large);
    	System.out.println(xLarge);

    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(xSmall);
    	list.add(small);
    	list.add(medium);
    	list.add(large);
    	list.add(xLarge);
    	Integer i2 = Collections.min(list);
    	System.out.println(i2);
/*    	for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(i2) {

			}
		}*/
    	return matchingSize;
    }
}
