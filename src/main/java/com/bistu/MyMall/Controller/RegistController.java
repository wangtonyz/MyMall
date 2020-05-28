package com.bistu.MyMall.Controller;

import com.bistu.MyMall.Bean.User;
import com.bistu.MyMall.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistController {
    @Autowired
    UserService userService;
    //创建一个新用户
    @RequestMapping("/addUser")
    public Boolean addUser(@RequestParam(value = "username") String username, @RequestParam(value = "pwd") String pwd) throws Exception {
        try {
            User users = new User();
            users.setUname(username);
            users.setPwd(pwd);
            userService.addUser(users);
            System.out.println("add用户: " + username + "\n密码: " + pwd);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

