package com.ruochen.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {
    @Override
    // Java类型 -> 数据库类型
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        preparedStatement.setLong(i, time);
    }

    @Override
    // 数据库类型 -> Java类型
    // ResultSet：查询出的结果集
    // String参数：要转换的字段名称
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        // 获取结果集中需要的数据(long) 转换为 Date 类型并返回
        long aLong = resultSet.getLong(s);
        Date date = new Date(aLong);
        return date;
    }

    @Override
    // 数据库类型 -> Java类型
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long aLong = resultSet.getLong(i);
        Date date = new Date(aLong);
        return date;
    }

    @Override
    // 数据库类型 -> Java类型
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
}
