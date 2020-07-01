package com.neusoft.controller;

import com.neusoft.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/DemoController")
public class DemoController {
    @RequestMapping("/demo")
    public String demo(Model m){
        List<User> list = new ArrayList<>();
        User u1 = new User();
        User u2 = new User();
        u1.setUserid(3);
        u1.setUsername("郭郭");
        u1.setPassword("12");
        u1.setRole("管理员");
        list.add(u1);
        u2.setUserid(4);
        u2.setUsername("陈陈");
        u2.setPassword("123");
        u2.setRole("管理员2");
        list.add(u2);
        m.addAttribute("list",list);
        return "/demo.html";
    }

}
