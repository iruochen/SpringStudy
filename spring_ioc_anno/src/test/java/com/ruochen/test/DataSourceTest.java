package com.ruochen.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.util.ResourceBundle;

public class DataSourceTest {
    @Test
    // 测试手动创建 c3p0 数据源(加载properties配置文件)
    public void test3() throws Exception {
        // 读取配置文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");
        // 创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 设置数据源的基本连接数据
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    // 测试手动创建 druid 数据源
    public void test2() throws Exception {
        // 创建数据源对象
        DruidDataSource dataSource = new DruidDataSource();
        // 设置数据源的基本连接数据
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db1");
        dataSource.setUsername("root");
        dataSource.setPassword("ruochen666");
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        // 归还资源
        connection.close();
    }

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
