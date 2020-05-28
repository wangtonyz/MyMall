package com.bistu.MyMall.Controller;

import com.bistu.MyMall.Bean.User;
import com.bistu.MyMall.Service.UserService;
import com.bistu.MyMall.result.Result;
import com.bistu.MyMall.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping("/checkpwd")
    public String checkpwd(@RequestParam(value = "pwd") String pwd, @RequestParam(value = "username") String username) throws Exception {
        try {
            User user = userService.findOne(username);
           
            if (user.getPwd().equals(pwd)) {
                return String.valueOf(user.getUid());
            }
        } catch (Exception e) {
            return "false";
        }
        return "false";
    }


}
