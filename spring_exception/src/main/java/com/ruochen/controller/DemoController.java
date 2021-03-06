package com.ruochen.controller;

import com.ruochen.exception.MyException;
import com.ruochen.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;

@Controller
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/show")
    public String show() throws MyException {
        System.out.println("show running....");
        // demoService.show1();
        // demoService.show2();
        // demoService.show3();
        // demoService.show4();
        demoService.show5();
        return "index";
    }

}
