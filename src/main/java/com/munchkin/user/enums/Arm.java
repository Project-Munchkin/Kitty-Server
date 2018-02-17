package com.munchkin.user.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.munchkin.enums.ValueEnum;
import com.munchkin.typehandler.IntegerValueEnumTypeHandler;
import org.apache.ibatis.type.MappedTypes;

public enum Arm implements ValueEnum<Integer> {

    SHORT(1), NORMAL(2), LONG(3);

    private final int value;

    Arm(int value) {
        this.value = value;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    @JsonCreator
    public static Arm valueOf(int value) {
        switch (value) {
            case 1:
                return SHORT;
            case 2:
                return NORMAL;
            case 3:
                return LONG;
            default:
                throw new AssertionError("Unknown value: " + value);
        }
    }

    @MappedTypes(Arm.class)
    public static class TypeHandler extends IntegerValueEnumTypeHandler<Arm> {
        public TypeHandler() {
            super(Arm.class);
        }
    }
}
