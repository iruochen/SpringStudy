package com.ruochen.controller;

import com.ruochen.domain.User;
import com.ruochen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView list() {
        List<User> userList = userService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
}
