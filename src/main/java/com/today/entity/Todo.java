package com.today.entity;

import java.util.Date;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/18 11:11
 */
public class Todo {
    private int todoId;//待办ID
    private Integer scheduleId;//关联日程ID
    private int userId;//关联用户ID
    private int todoProgressRate;//待办完成进程进度百分比（０％－１００％）
    private int repeatType;//待办重复类型
    private int todoState;//待办状态
    private int todoType;//待办类型
    private int priority;//待办优先级
    private Date beginTime;//开始时间
    private Date endTime;//DDL
    private String content;//待办内容

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTodoProgressRate() {
        return todoProgressRate;
    }

    public void setTodoProgressRate(int todoProgressRate) {
        this.todoProgressRate = todoProgressRate;
    }

    public int getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(int repeatType) {
        this.repeatType = repeatType;
    }

    public int getTodoState() {
        return todoState;
    }

    public void setTodoState(int todoState) {
        this.todoState = todoState;
    }


    public int getTodoType() {
        return todoType;
    }

    public void setTodoType(int todoType) {
        this.todoType = todoType;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
