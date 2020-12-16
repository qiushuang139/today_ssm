package com.today.controller;

import com.today.component.annotation.Authorization;
import com.today.component.annotation.CurrentUser;
import com.today.entity.User;
import com.today.entity.UserPasswordRecord;
import com.today.model.ResultModel;
import com.today.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author :zhangyi
 * @description:与登陆界面有关的API
 * @date :2020/11/16 22:15
 */

@RestController
@RequestMapping("/users")
public class UserController {

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
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user){
        try {
            if(userService.isExists(user.getUserId()))
                return new ResponseEntity(new ResultModel(HttpStatus.OK,(Boolean)false),HttpStatus.OK);
            userService.addUser(user);
            return new ResponseEntity(new ResultModel(HttpStatus.OK,userService.getUserById(user.getUserId())),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    /**
     * @description:更新系统中已经存在的User
     * @param user  将要更新的User
     * @return:0:修改失败，1:修改成功
    */
    @RequestMapping(value = "/{userId}",method = RequestMethod.PUT)
    @Authorization
    public ResponseEntity updateUser(@PathVariable("userId") int userId,@RequestBody User user){
        try {
            if(userService.isExists(user.getUserId())) {
                userService.updateUser(user);
                return new ResponseEntity(
                        new ResultModel(HttpStatus.OK,userService.getUserById(user.getUserId())),
                        HttpStatus.OK);
            }
            return new ResponseEntity(new ResultModel(HttpStatus.OK,(Boolean)false),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updatePassword",method =RequestMethod.POST)
    @Authorization
    public ResponseEntity updatePassword(@CurrentUser UserPasswordRecord userPasswordRecord){
        try {
            if(userService.getUserById(userPasswordRecord.getUserId()).getPassword()
                    .equals(userPasswordRecord.getPassword())){
                userService.updatePassword(userPasswordRecord.getUserId(),userPasswordRecord.getNewPassword());
                return new ResponseEntity(new ResultModel(HttpStatus.OK),HttpStatus.OK);
            }
            return new ResponseEntity(
                    new ResultModel(HttpStatus.FORBIDDEN,"密码错误"),HttpStatus.FORBIDDEN);
        }catch (Exception ex){
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


    /**
     * @description:根据userId返回对应的User
     * @param userId 待查询的userId
     * @return:返回user
    */
    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getUserById(@PathVariable("userId") int userId){
        try {
            User user = userService.getUserById(userId);
            user.setPassword("");
            return new ResponseEntity(new ResultModel(HttpStatus.OK,user),HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Authorization
    public ResponseEntity deleteUserByUserId(@CurrentUser User user){
        try {
            userService.deleteUserByUserId(user.getUserId());
            return new ResponseEntity(
                    new ResultModel(HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
