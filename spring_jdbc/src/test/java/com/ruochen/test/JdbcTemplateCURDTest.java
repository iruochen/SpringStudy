package com.ruochen.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
