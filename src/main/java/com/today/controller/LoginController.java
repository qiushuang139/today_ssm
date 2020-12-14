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
 * @description:与登陆界面有关的API
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
    
    
    /**
     * @description:向系统中添加User（注册User）
     * @param user 将要添加的用户类
     * @return: 0:添加失败，1:添加成功
    */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Integer addUser(@RequestBody User user){
        try {
            if(userService.isExists(user.getUserId()))
                return 0;
            return userService.addUser(user);
        }catch (Exception ex){
            ex.printStackTrace();
            return 0;
        }
    }

    /**
     * @description:更新系统中已经存在的User
     * @param user  将要更新的User
     * @return:0:添加失败，1:添加成功
    */
    @RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
    public Integer updateUser(@RequestBody User user){
        try {
            if(userService.isExists(user.getUserId()))
                return userService.updateUser(user);
            return 0;
        }catch (Exception ex){
            ex.printStackTrace();
            return 0;
        }
    }

    /**
     * @description:判断用户输入的账号与密码是否匹配
     * @param user 用户输入的账号与密码
     * @return: true:账号与密码匹配，false:账号与密码不匹配
    */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public boolean isPasswordEquals(@RequestBody User user){
        try {
            String targetPassword = userService.getPasswordById(user.getUserId());
            if (targetPassword.equals(user.getPassword()))
                return true;
            return false;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * @description:根据userId返回对应的User
     * @param userId 待查询的userId
     * @return:返回user
    */
    @RequestMapping(value = "/getUser/{userId}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("userId") int userId){
        try {
            User user = userService.getUserById(userId);
            user.setPassword("");
            return user;
        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

}
