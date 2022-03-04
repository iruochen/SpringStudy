package com.ruochen.test;

import com.ruochen.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    /**
     * 测试 scope
     * singleton：单一对象，加载配置文件、创建 Spring 容器时创建 bean
     * prototype：多个对象，执行 getBran()方法 时创建 bean
     */
    @Test
    public void test1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
//        ((ClassPathXmlApplicationContext) app).close();
    }
}
