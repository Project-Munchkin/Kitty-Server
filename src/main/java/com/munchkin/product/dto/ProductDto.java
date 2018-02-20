package com.munchkin.product.dto;

import com.munchkin.user.enums.Gender;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ProductDto {

    private int productSeq;
    private String productNumber;
    private String productName;

    @ApiModelProperty(required = true)
    private Gender gender;

    @ApiModelProperty(required = true)
    private int category;
 
    private String size;
    private int totalLength;
    private int shoulder;
    private int chest;
    private int arm;
    private int leg;
    private int waist;
    private int minHeight;
    private int maxHeight;
    private Date createTime;
    private Date modifyTime;
    private String appLogo;
    private String webLogo;

    @ApiModelProperty(required = true)
    private String brandName;

    public ProductDto() {}

    public ProductDto(int totalLength, int shoulder, int chest, int arm, int leg,
                      int waist,int minHeight, int maxHeight) {

        this.totalLength = totalLength;
        this.shoulder = shoulder;
        this.chest = chest;
        this.arm = arm;
        this.leg = leg;
        this.waist = waist;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public int getProductSeq() {
        return productSeq;
    }

    public void setProductSeq(int productSeq) {
        this.productSeq = productSeq;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(String appLogo) {
        this.appLogo = appLogo;
    }

    public String getWebLogo() {
        return webLogo;
    }

    public void setWebLogo(String webLogo) {
        this.webLogo = webLogo;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
