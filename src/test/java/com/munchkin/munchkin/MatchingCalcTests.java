package com.munchkin.munchkin;

import com.munchkin.product.dto.ProductDto;
import com.munchkin.product.service.ProductService;
import com.munchkin.user.dto.UserDto;
import com.munchkin.user.enums.Arm;
import com.munchkin.user.enums.BodyType;
import com.munchkin.user.enums.Gender;
import com.munchkin.user.enums.Shoulder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
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
        user = new UserDto(Gender.MAN, BodyType.NORMAL, 174, Shoulder.NORMAL, Arm.SHORT);
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
    	int xSmallVal = Math.abs(60 - size);
    	int smallVal = Math.abs(80 - size);
    	int mediumVal = Math.abs(100 - size);
    	int largeVal = Math.abs(120 - size);
    	int xLargeVal = Math.abs(140 - size);

    	SizeVal sizeVal = new SizeVal();
    	sizeVal.setxSmall(String.valueOf(xSmallVal));
    	sizeVal.setSmall(String.valueOf(smallVal));
    	sizeVal.setMedium(String.valueOf(mediumVal));
    	sizeVal.setLarge(String.valueOf(largeVal));
    	sizeVal.setxLarge(String.valueOf(xLargeVal));

    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(xSmallVal);
    	list.add(smallVal);
    	list.add(mediumVal);
    	list.add(largeVal);
    	list.add(xLargeVal);
    	Integer minVal = Collections.min(list);
    	   try{
		    	Object obj= sizeVal;
		    	for (Field field : obj.getClass().getDeclaredFields()){
		    		System.out.println(field.getName());
		            field.setAccessible(true);
		            Object value=field.get(obj);
		            System.out.println(value.toString());
		            //if (field.getType().equals(value.getClass())){
		            	if (minVal == Integer.parseInt(value.toString())){
		            		matchingSize = field.getName();
		            	}
		            //}
		            
		        }
    	   }catch(NumberFormatException e){
    		   System.out.println("여기는 안들어오겠지");
    	   }catch (Exception e){
	            e.printStackTrace();
	        }
    	   return matchingSize;
    }

    public class SizeVal {
        private String xSmall;
        private String small;
        private String medium;
        private String large;
        private String xLarge;

		public String getxSmall() {
			return xSmall;
		}
		public void setxSmall(String xSmall) {
			this.xSmall = xSmall;
		}
		public String getSmall() {
			return small;
		}
		public void setSmall(String small) {
			this.small = small;
		}
		public String getMedium() {
			return medium;
		}
		public void setMedium(String medium) {
			this.medium = medium;
		}
		public String getLarge() {
			return large;
		}
		public void setLarge(String large) {
			this.large = large;
		}
		public String getxLarge() {
			return xLarge;
		}
		public void setxLarge(String xLarge) {
			this.xLarge = xLarge;
		}
		@Override
		public String toString() {
			return "1";
		}
		
		
    }

	@Override
	public String toString() {
		return "MatchingCalcTests [productService=" + productService + ", user=" + user + "]";
	}

    
}
