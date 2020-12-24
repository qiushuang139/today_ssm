package com.today.dao;

import com.today.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/16 21:07
 */
public interface UserDao {
    String getPasswordById(@Param("userId") int userId);

    int addUser(User user);

    int updateUser(User user);

    int setUrlAvatarUrl(@Param("userId") int userId,@Param("path") String path);

    User getUserById(@Param("userId") int userId);

    User getUserByName(@Param("userName")String userName);

    int getMaxUserId();

    int isExists(@Param("userId")int userId);

    int deleteUser(int userId);

    int updatePassword(@Param("userId") int userId,@Param("newPassword") String newPassword);
}
