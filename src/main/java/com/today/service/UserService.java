package com.today.service;

import com.today.entity.User;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/16 22:16
 */
public interface UserService {

    User getUserById(int userId);

    String getPasswordById(int userId);

    int addUser(User user);

    int updateUser(User user);

    int getMaxUserId();
}
