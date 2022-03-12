package com.ruochen.controller;

import com.ruochen.domain.Account;
import com.ruochen.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // 保存
    @RequestMapping("/save")
    @ResponseBody
    public String save(Account account) {
        System.out.println(account);
        return "保存成功";
    }

    // 查询
    public ModelAndView findAll() {
        List<Account> accountList = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList", accountList);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}
