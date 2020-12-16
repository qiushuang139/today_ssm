package com.today.entity;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/12/16 10:55
 */
public class UserPasswordRecord {
    private int userId;
    private String password;
    private String newPassword;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}


