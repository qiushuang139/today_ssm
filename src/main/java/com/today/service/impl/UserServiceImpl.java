package com.today.service.impl;

import com.today.dao.UserDao;
import com.today.entity.User;
import com.today.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/16 22:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public String getPasswordById(int userId) {
        return userDao.getPasswordById(userId);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }
}
