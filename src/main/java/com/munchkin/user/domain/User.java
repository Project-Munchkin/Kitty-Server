package com.munchkin.user.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.munchkin.user.deserializer.UserDeserializer;
import com.munchkin.user.enums.BodyType;
import com.munchkin.user.enums.Gender;

//@JsonDeserialize(using = UserDeserializer.class)
public class User {

    private Gender gender;
    private BodyType bodyType;
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
