package com.munchkin.user.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.munchkin.enums.ValueEnum;
import com.munchkin.typehandler.IntegerValueEnumTypeHandler;
import org.apache.ibatis.type.MappedTypes;

public enum Shoulder implements ValueEnum<Integer> {

    NARROW(1), NORMAL(2), BROAD(3);

    private final int value;

    Shoulder(int value) {
        this.value = value;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    @JsonCreator
    public static Shoulder valueOf(int value) {
        switch (value) {
            case 1:
                return NARROW;
            case 2:
                return NORMAL;
            case 3:
                return BROAD;
            default:
                throw new AssertionError("Unknown value: " + value);
        }
    }

    @MappedTypes(Shoulder.class)
    public static class TypeHandler extends IntegerValueEnumTypeHandler<Shoulder> {
        public TypeHandler() {
            super(Shoulder.class);
        }
    }
}
