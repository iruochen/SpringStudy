package com.ruochen.test;

import com.ruochen.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCURDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    // 测试修改操作
    public void testUpdate() {
        int row = jdbcTemplate.update("update account set money=? where name=?", 10000, "tom");
        System.out.println(row);
    }

    @Test
    // 测试删除操作
    public void testDelete() {
        int row = jdbcTemplate.update("delete from account where name=?", "tom");
        System.out.println(row);
    }

    @Test
    // 测试查询操作(查询多个对象)
    public void testQuery() {
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    @Test
    // 测试查询操作(查询单个对象)
    public void testQueryOne() {
        // jdbcTemplate.queryForObject();
        Account account = jdbcTemplate.queryForObject("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), "tom");
        System.out.println(account);
    }

    @Test
    // 查询总条数(聚合查询)
    public void testQueryCount() {
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }
}
