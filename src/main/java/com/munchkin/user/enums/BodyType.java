package com.munchkin.user.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.munchkin.enums.ValueEnum;
import com.munchkin.typehandler.IntegerValueEnumTypeHandler;
import org.apache.ibatis.type.MappedTypes;

public enum BodyType implements ValueEnum<Integer> {

    THIN(1), NORMAL(2), FAT(3);

    private final int value;

    BodyType(int value) {
        this.value = value;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    @JsonCreator
    public static BodyType valueOf(int value) {
        switch (value) {
            case 1:
                return THIN;
            case 2:
                return NORMAL;
            case 3:
                return FAT;
            default:
                throw new AssertionError("Unknown value: " + value);
        }
    }

    @MappedTypes(BodyType.class)
    public static class TypeHandler extends IntegerValueEnumTypeHandler<BodyType> {
        public TypeHandler() {
            super(BodyType.class);
        }
    }
}
