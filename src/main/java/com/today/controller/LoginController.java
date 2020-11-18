package com.today.controller;

import com.today.entity.User;
import com.today.service.UserService;
import com.today.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/16 22:15
 */
@Controller()
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String index(){
        return "success";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Integer addUser(User user){
        return userService.addUser(user);
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Integer updateUser(User user){
        return userService.updateUser(user);
    }

    @RequestMapping("/login")
    @ResponseBody
    public boolean isPasswordEquals(int userId,String password){
        String targetPassword=userService.getPasswordById(userId);
        if(targetPassword.equals(password))
            return true;
        return false;
    }

    @RequestMapping("/getUser/{userId}")
    @ResponseBody
    public User getUserById(@PathVariable("userId") int userId){
        return userService.getUserById(userId);
    }

}
