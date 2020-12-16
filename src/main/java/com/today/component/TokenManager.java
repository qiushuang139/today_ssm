package com.today.component;

import com.today.entity.Token;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/12/15 14:31
 */
public interface TokenManager {
    public Token createToken(int userId);

    public boolean checkToken(Token token);

    public Token getToken(String authentication);

    public void deleteToken(int userId);
}
