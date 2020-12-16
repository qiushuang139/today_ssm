package com.today.controller;

import com.today.component.*;
import com.today.component.annotation.Authorization;
import com.today.component.annotation.CurrentUser;
import com.today.entity.Token;
import com.today.entity.User;
import com.today.model.ResultModel;
import com.today.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/12/15 15:19
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {



    @Autowired
    private UserService userService;

    @Qualifier("redisTokenManager")
    @Autowired
    private TokenManager tokenManager;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity login(@RequestParam int userId,@RequestParam String password){
        Assert.notNull(userId,"userId can't be empty");
        Assert.notNull(password,"password can't be empty");

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
