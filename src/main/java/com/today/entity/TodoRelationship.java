package com.today.entity;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/24 14:58
 */
public class TodoRelationship {
    private int childTodoId;
    private int parentTodoId;

    public int getChildTodoId() {
        return childTodoId;
    }

    public void setChildTodoId(int childTodoId) {
        this.childTodoId = childTodoId;
    }

    public int getParentTodoId() {
        return parentTodoId;
    }

    public void setParentTodoId(int parentTodoId) {
        this.parentTodoId = parentTodoId;
    }
}
