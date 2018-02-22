package com.munchkin.product.dto;

import com.munchkin.user.dto.UserDto;
import com.munchkin.user.enums.Arm;
import com.munchkin.user.enums.BodyType;
import com.munchkin.user.enums.Gender;
import com.munchkin.user.enums.Shoulder;
import io.swagger.annotations.ApiModelProperty;

public class MatchingDto {

    @ApiModelProperty(required = true)
    private Gender gender;

    @ApiModelProperty(required = true)
    private BodyType bodyType;

    @ApiModelProperty(required = true)
    private int height;

    @ApiModelProperty(required = true)
    private Shoulder shoulder;

    @ApiModelProperty(required = true)
    private Arm arm;

    @ApiModelProperty(required = true)
    private int category;

    @ApiModelProperty(required = true)
    private String brandName;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Shoulder getShoulder() {
        return shoulder;
    }

    public void setShoulder(Shoulder shoulder) {
        this.shoulder = shoulder;
    }

    public Arm getArm() {
        return arm;
    }

    public void setArm(Arm arm) {
        this.arm = arm;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public UserDto toUserDto() {
        return new UserDto(gender, bodyType, height, shoulder, arm);
    }
}
