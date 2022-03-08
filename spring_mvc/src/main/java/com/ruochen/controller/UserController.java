package com.ruochen.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruochen.domain.User;
import com.ruochen.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId) {
        System.out.println(jsessionId);
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent", required = false) String userAgent) {
        System.out.println(userAgent);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date) {
        System.out.println(date);
    }

    @RequestMapping(value = "/quick17/{name}")
    @ResponseBody
    public void save17(@PathVariable("name") String username) {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "ruochen") String username) {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) {
        System.out.println(userList);
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(VO vo) {
        System.out.println(vo);
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs) {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user) {
        System.out.println(user);
    }

    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username, int age) {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody  // 告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    // 期望 Spring 自动将 User 转换为 json 格式字符串
    public User save10() {
        User user = new User();
        user.setUsername("ruochen");
        user.setAge(22);
        return user;
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody  // 告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("ruochen");
        user.setAge(22);
        // 使用 json 转换工具将对象转换为 json 格式字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody  // 告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String save8() {
        return "{\"username\": \"zhangsan\", \"age\": 18}";
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody  // 告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String save7() {
        return "hello ruochen2";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello ruochen");
    }

    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request) {
        // 不常用
        request.setAttribute("username", "ruochen5");
        return "success";
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model) {
        model.addAttribute("username", "若尘");
        return "success";
    }

    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        // 设置模型数据
        modelAndView.addObject("username", "ruochen2");
        // 设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2() {
        /*
            Model：模型 作用封装数据
            View： 视图 作用展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        // 设置模型数据
        modelAndView.addObject("username", "ruochen");
        // 设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    // 请求地址 http://localhost:8080/user/quick
    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("Controller save running....");
        return "success";
    }
}
