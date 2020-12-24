package com.today.service;

import com.today.entity.User;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/16 22:16
 */
public interface UserService {
    User getUserByName(String userName);

    User getUserById(int userId);

    String getPasswordById(int userId);

    int addUser(User user);

    int updateUser(User user);

    int getMaxUserId();

    boolean isExists(int userId);

    int deleteUserByUserId(int userId);

    int updatePassword(int userId,String newPassword);

    int storeAvatar(MultipartFile avatar,String path,int userId) throws Exception;
}
