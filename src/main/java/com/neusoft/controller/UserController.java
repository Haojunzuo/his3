package com.neusoft.controller;

import com.neusoft.entity.User;
import com.neusoft.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/UserController")
public class UserController {
    @Resource
    private UserService userService;

    /*这里使用的是@RequestMapping()  和 @ResponseBody 两个注解，代替了以往使用的@GetMapping()和
    * @RequestMapping()注解，现在还不清楚这两个新注解在一起是什么意思。
    * */
    @RequestMapping("/selectRoles")
    @ResponseBody
    public List<String> selectRoles(){
        return userService.selectRoles();
    }

    @RequestMapping("/selectUser")
    @ResponseBody
    public String selectUser(User u, HttpSession session){
        User user = userService.selectUser(u);
        if (user != null) {
            session.setAttribute("user",user);
            return user.getRole();
        }else{
            return "error";//这里的error是直接把error给返回到浏览器页面了。
        }
    }
}