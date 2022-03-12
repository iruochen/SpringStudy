package com.ruochen.test;

import com.ruochen.domain.Order;
import com.ruochen.domain.User;
import com.ruochen.mapper.OrderMapper;
import com.ruochen.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest2 {
    private OrderMapper mapper;

    @Before
    public void before() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(OrderMapper.class);

    }

    @Test
    public void testFindAll() {
        List<Order> all = mapper.findAll();
        for (Order order : all) {
            System.out.println(order);
        }

    }
}
