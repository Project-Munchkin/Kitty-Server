package com.munchkin.typehandler;

import com.munchkin.enums.ValueEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IntegerValueEnumTypeHandler<T extends ValueEnum<Integer>> implements TypeHandler<ValueEnum<Integer>> {

    private Class<T> clazz;

    public IntegerValueEnumTypeHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, ValueEnum<Integer> integerValueEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, integerValueEnum.getValue());
    }

    @Override
    public ValueEnum<Integer> getResult(ResultSet resultSet, String s) throws SQLException {
        return valueOf(resultSet.getInt(s));
    }

    @Override
    public ValueEnum<Integer> getResult(ResultSet resultSet, int i) throws SQLException {
        return valueOf(resultSet.getInt(i));
    }

    @Override
    public ValueEnum<Integer> getResult(CallableStatement callableStatement, int i) throws SQLException {
        return valueOf(callableStatement.getInt(i));
    }

    private ValueEnum<Integer> valueOf(int value) {
        try {
            ValueEnum<Integer>[] valueEnums = clazz.getEnumConstants();
            for (ValueEnum<Integer> valueEnum : valueEnums) {
                if (valueEnum.getValue().equals(value)) {
                    return valueEnum;
                }
            }
            return null;
        } catch (Exception e) {
            throw new TypeException("Can't make enum object: " + clazz, e);
        }
    }
}
