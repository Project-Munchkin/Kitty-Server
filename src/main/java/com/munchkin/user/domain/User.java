package com.munchkin.user.domain;

import com.munchkin.user.enums.BodyType;
import com.munchkin.user.enums.Gender;
import io.swagger.annotations.ApiModelProperty;

public class User {

    @ApiModelProperty(required = true, allowableValues = "1, 2")
    private Gender gender;

    @ApiModelProperty(required = true, allowableValues = "1, 2, 3")
    private BodyType bodyType;

    @ApiModelProperty(required = true)
    private int height;

    public User() {
    }

    public User(Gender gender, BodyType bodyType, int height) {
        this.gender = gender;
        this.bodyType = bodyType;
        this.height = height;
    }

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
}
