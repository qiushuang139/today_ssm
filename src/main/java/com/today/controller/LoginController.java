package com.today.controller;

import com.today.entity.User;
import com.today.service.UserService;
import com.today.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/16 22:15
 */

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping("/test")
    public String index(){
        return "success";
    }
    
    

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Integer addUser(@RequestBody User user){
        int userId=userService.getMaxUserId();
        user.setUserId(userId+1);
        return userService.addUser(user);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
    public Integer updateUser(User user){
        return userService.updateUser(user);
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public boolean isPasswordEquals(int userId,String password){
        String targetPassword=userService.getPasswordById(userId);
        if(targetPassword.equals(password))
            return true;
        return false;
    }

    @RequestMapping(value = "/getUser/{userId}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("userId") int userId){
        return userService.getUserById(userId);
    }

}
