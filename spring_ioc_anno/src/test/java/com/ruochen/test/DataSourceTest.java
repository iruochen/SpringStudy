package com.ruochen.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class DataSourceTest {
    @Test
    // 测试手动创建 c3p0 数据源
    public void test1() throws Exception {
        // 创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 设置数据源的基本连接数据
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db1");
        dataSource.setUser("root");
        dataSource.setPassword("ruochen666");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
