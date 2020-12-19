package com.today.service.impl;

import com.today.dao.ScheduleDao;
import com.today.dao.TodoDao;
import com.today.dao.TodoRelationshipDao;
import com.today.dao.UserDao;
import com.today.entity.User;
import com.today.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/16 22:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ScheduleDao scheduleDao;

    @Autowired
    private TodoDao todoDao;

    @Autowired
    private TodoRelationshipDao todoRelationshipDao;


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

    @Override
    public int getMaxUserId() {
        return userDao.getMaxUserId();
    }

    @Override
    public boolean isExists(int userId) {
        return userDao.isExists(userId)>0;
    }

    @Override
    public int deleteUserByUserId(int userId) {
        //删除所有与用户相关的信息
        List<Integer> scheduleIds=scheduleDao.getScheduleIdsByUserId(userId);
        for (Integer scheduleId:scheduleIds){
            List<Integer> todoIds=todoDao.getTodoIdsByScheduleId(scheduleId);
            for(Integer todoId:todoIds){
                todoRelationshipDao.deleteTodoRelationshipByTodoId(todoId);
                todoDao.deleteTodoByTodoId(todoId);
            }
            scheduleDao.deleteScheduleByScheduleId(scheduleId);
        }
        return userDao.deleteUser(userId);
    }

    @Override
    public int updatePassword(int userId,String newPassword) {
        return userDao.updatePassword(userId,newPassword);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }

    @Override
    public int storeAvatar(MultipartFile avatar, String path,int userId)throws Exception {
        File file=new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        avatar.transferTo(new File(path+"\\"+userId+".jpg"));
        return userDao.setUrlAvatarUrl(userId,path);
    }
}
