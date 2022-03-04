package com.ruochen.demo;

import com.ruochen.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
        // 推荐使用
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 不推荐使用
        // ApplicationContext app = new FileSystemXmlApplicationContext("D:\\IDEAWorkspace\\SpringStudy\\spring_ioc_study\\src\\main\\resources\\applicationContext.xml");
        // UserService userService = (UserService) app.getBean("userService");
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
