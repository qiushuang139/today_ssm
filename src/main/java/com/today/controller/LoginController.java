package com.today.controller;

import com.today.entity.User;
import com.today.service.UserService;
import com.today.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/16 22:15
 */
@Controller()
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String index(){
        return "index";
    }

    @RequestMapping("")
    public boolean addUser(User user){
        return userService.addUser(user)>0?true:false;
    }

    public boolean updateUser(User user){
        return userService.updateUser(user)>0?true:false;
    }

    public boolean isPasswordEquals(int userId,String password){
        String targetPassword=userService.getPasswordById(userId);
        if(targetPassword.equals(password))
            return true;
        return false;
    }

    @RequestMapping("getUser/{userId}")
    public User getUserById(int userId){
        return userService.getUserById(userId);
    }

}
