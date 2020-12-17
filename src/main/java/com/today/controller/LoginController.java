package com.today.controller;

import com.today.component.*;
import com.today.component.annotation.Authorization;
import com.today.component.annotation.CurrentUser;
import com.today.entity.Token;
import com.today.entity.User;
import com.today.entity.UserPasswordRecord;
import com.today.model.ResultModel;
import com.today.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/12/15 15:19
 */
@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private UserService userService;

    @Qualifier("redisTokenManager")
    @Autowired
    private TokenManager tokenManager;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody UserPasswordRecord record){
        int userId=record.getUserId();
        String password=record.getPassword();

        User user=userService.getUserById(userId);
        if(user==null||!user.getPassword().equals(password)){
            return new ResponseEntity(new ResultModel(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        Token token=tokenManager.createToken(userId);
        System.out.println(token);
        return new ResponseEntity(new ResultModel(HttpStatus.OK,token),HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.DELETE)
    @Authorization
    public ResponseEntity logout(@CurrentUser User user){

        System.out.println("删除token");
        tokenManager.deleteToken(user.getUserId());
        return new ResponseEntity(new ResultModel(HttpStatus.OK),HttpStatus.OK);
    }
}
