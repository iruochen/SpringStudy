package com.ruochen.test;

import com.ruochen.domain.User;
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

public class MybatisTest {
    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);

    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("tom");
        user.setPassword("abc");
        mapper.save(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(6);
        user.setUsername("lucy");
        user.setPassword("123");
        mapper.update(user);
    }

    @Test
    public void testDelete() {
        mapper.delete(6);
    }

    @Test
    public void testFindById() {
        User user = mapper.findById(2);
        System.out.println(user);
    }

    @Test
    public void testFindAll() {
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
