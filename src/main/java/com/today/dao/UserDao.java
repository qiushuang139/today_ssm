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

    User getUserById(@Param("userId") int userId);

    int getMaxUserId();

    int isExists(@Param("userId")int userId);

    int deleteUser(int userId);

    int updatePassword(@Param("userId") int userId,@Param("newPassword") String newPassword);
}
