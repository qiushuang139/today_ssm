package com.today.model;

import org.springframework.http.HttpStatus;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/12/15 16:16
 */
public class ResultModel {
    private int code;//返回码
    private String message;//返回结果描述
    private Object content;//返回内容

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    public Object getContent() {
        return content;
    }

    public ResultModel(int code){
        this.code=code;
    }

    public ResultModel(int code,String message){
        this.code=code;
        this.message=message;
        this.content="";
    }

    public ResultModel(int code,String message,Object content){
        this.code=code;
        this.message=message;
        this.content=content;
    }

    public ResultModel(HttpStatus status){
        this.code=status.value();
        this.message=status.getReasonPhrase();
        this.content="";
    }

    public ResultModel(HttpStatus status,Object content){
        this.content=status.value();
        this.message=status.getReasonPhrase();
        this.content=content;
    }
}
