package com.bistu.MyMall.Controller;

import com.bistu.MyMall.Bean.User;
import com.bistu.MyMall.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private UserService userService;
    //查询全部用户
    @RequestMapping("/listUserinfo")//api接口
    public List<User> listUserinfo() throws Exception {
        return userService.findAll();//List类型会自动转换为JSON
    }

    //查询某个用户
    @RequestMapping("/finduser")
    public User findUser(@RequestParam(value = "username") String username) {
        User user = userService.findOne(username);
        System.out.println(user.getUname() + '\n' + user.getPwd());
        return user;
    }



}
