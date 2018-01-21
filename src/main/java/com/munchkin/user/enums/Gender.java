package com.munchkin.user.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.munchkin.enums.ValueEnum;
import com.munchkin.typehandler.IntegerValueEnumTypeHandler;
import org.apache.ibatis.type.MappedTypes;

public enum Gender implements ValueEnum<Integer> {

    MAN(1), WOMAN(2);

    private final int value;

    Gender(int value) {
        this.value = value;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    @JsonCreator
    public static Gender valueOf(int value) {
        switch (value) {
            case 1:
                return MAN;
            case 2:
                return WOMAN;
            default:
                throw new AssertionError("Unknown value: " + value);
        }
    }

    @MappedTypes(Gender.class)
    public static class TypeHandler extends IntegerValueEnumTypeHandler<Gender> {
        public TypeHandler() {
            super(Gender.class);
        }
    }
}
