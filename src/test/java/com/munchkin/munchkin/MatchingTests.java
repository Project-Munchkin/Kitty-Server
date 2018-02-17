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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatchingTests {

    @Autowired
    private ProductService productService;

    private UserDto user1;
    private UserDto user2;
    private UserDto user3;

    @Before
    public void setup() {
        user1 = new UserDto(Gender.MAN, BodyType.NORMAL, 174, Shoulder.NARROW, Arm.SHORT);
        user2 = new UserDto(Gender.MAN, BodyType.NORMAL, 165, Shoulder.NORMAL, Arm.NORMAL);
        user3 = new UserDto(Gender.WOMAN, BodyType.THIN, 174, Shoulder.BROAD, Arm.LONG);
    }

    @Test
    public void size() {
        System.out.println(user1.getSize());
        System.out.println(user2.getSize());
        System.out.println(user3.getSize());
    }

    @Test
    public void match() {
        Map<String, List<ProductDto>> shirtsByBrand = productService.getAllShirtsByBrand();

        Map<String, AverageProductDto> avgShirts = getAvgProduct(shirtsByBrand);
        Set<String> keySet = avgShirts.keySet();

        for (String key : keySet) {
            AverageProductDto avgShirt = avgShirts.get(key);
            System.out.println("========== size " + key + " ==========");
            System.out.println(avgShirt);
        }
    }

    private Map<String, AverageProductDto> getAvgProduct(Map<String, List<ProductDto>> productsByBrand) {
        Map<String, AverageProductDto> averageProductsBySize = new HashMap<>();

        Set<String> keys = productsByBrand.keySet();
        for (String key : keys) {
            List<ProductDto> products = productsByBrand.get(key);
            for (ProductDto product : products) {
                if (averageProductsBySize.get(product.getSize()) == null) {
                    averageProductsBySize.put(product.getSize(), new AverageProductDto());
                }

                AverageProductDto averageProduct = averageProductsBySize.get(product.getSize());
                System.out.println(averageProduct);

                averageProduct.setTotalLength(averageProduct.getTotalLength() + product.getTotalLength());
                averageProduct.setShoulder(averageProduct.getShoulder() + product.getShoulder());
                averageProduct.setChest(averageProduct.getChest() + product.getChest());
                averageProduct.setArm(averageProduct.getArm() + product.getArm());
                averageProduct.setLeg(averageProduct.getLeg() + product.getLeg());
                averageProduct.setWaist(averageProduct.getWaist() + product.getWaist());
                averageProduct.setMinHeight(averageProduct.getMinHeight() + product.getMinHeight());
                averageProduct.setMaxHeight(averageProduct.getMaxHeight() + product.getMaxHeight());

                averageProduct.increaseCount();
            }
        }

        Set<String> keySet = averageProductsBySize.keySet();
        for (String key : keySet) {
            AverageProductDto averageProduct = averageProductsBySize.get(key);
            averageProduct.setAverage();
        }

        return averageProductsBySize;
    }

    private class AverageProductDto {

        private int count;
        private int totalLength;
        private int shoulder;
        private int chest;
        private int arm;
        private int leg;
        private int waist;
        private int minHeight;
        private int maxHeight;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void increaseCount() {
            this.count++;
        }

        public int getTotalLength() {
            return totalLength;
        }

        public void setTotalLength(int totalLength) {
            this.totalLength = totalLength;
        }

        public int getShoulder() {
            return shoulder;
        }

        public void setShoulder(int shoulder) {
            this.shoulder = shoulder;
        }

        public int getChest() {
            return chest;
        }

        public void setChest(int chest) {
            this.chest = chest;
        }

        public int getArm() {
            return arm;
        }

        public void setArm(int arm) {
            this.arm = arm;
        }

        public int getLeg() {
            return leg;
        }

        public void setLeg(int leg) {
            this.leg = leg;
        }

        public int getWaist() {
            return waist;
        }

        public void setWaist(int waist) {
            this.waist = waist;
        }

        public int getMinHeight() {
            return minHeight;
        }

        public void setMinHeight(int minHeight) {
            this.minHeight = minHeight;
        }

        public int getMaxHeight() {
            return maxHeight;
        }

        public void setMaxHeight(int maxHeight) {
            this.maxHeight = maxHeight;
        }

        public void setAverage() {
            this.totalLength /= this.count;
            this.shoulder /= this.count;
            this.chest /= this.count;
            this.arm /= this.count;
            this.leg /= this.count;
            this.waist /= this.count;
            this.minHeight /= this.count;
            this.maxHeight /= this.count;
        }

        @Override
        public String toString() {
            return "totalLength = " + this.totalLength + ", shoulder = " + this.shoulder +
                    ", chest = " + this.chest + ", arm = " + this.arm + ", leg = " + this.leg +
                    ", waist = " + this.waist + ", minHeight = " + this.minHeight + ", maxHeight = " + this.maxHeight;
        }
    }
}
