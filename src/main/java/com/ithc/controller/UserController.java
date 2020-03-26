package com.ithc.controller;

import com.ithc.pojo.User;
import com.ithc.service.Impl.UserServiceImpl;
import com.ithc.service.UserService;
import jdk.nashorn.internal.parser.Token;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@Controller
public class UserController {

//    @GetMapping("/login")
//    public String login(){
//        System.out.println("login page");
//        return "redirect:/index.jsp";
//    }

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String loginLogic(User user ){
        System.out.println("login logic");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(true);
        subject.login(token);
        return "redirect:/index1.jsp";
    }

    @RequestMapping("/all")
    public String queryAll(){
        System.out.println("queryAll");
        return "index";
    }

    @RequestMapping("/perms/error")
    public String permsError(){
        System.out.println("权限不足");
        return "perm_error";
    }

    @RequestMapping("/regist")
    public String regist(User user){
        userService.insertUser(user);
        return "redirect:/index.jsp";
    }
}
