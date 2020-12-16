package com.today.entity;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/12/15 14:28
 */
public class Token {
    private int userId;
    private String token;

    public Token(int userId,String token){
        this.userId=userId;
        this.token=token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
