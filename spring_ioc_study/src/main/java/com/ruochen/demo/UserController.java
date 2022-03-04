package com.ruochen.demo;

import com.ruochen.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();

        // 不是从容器拿的 userService，会报错空指针异常
        // UserService userService = new UserServiceImpl();
        // userService.save();
    }
}
