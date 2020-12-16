package com.today.service;

import com.today.entity.Todo;

import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/18 11:11
 */
public interface TodoService {

    int addTodo(Todo todo);

    int updateTodo(Todo todo);

    int deleteTodoByTodoId(int todoId);


    int deleteTodoRealationshipByTodoId(int todoId);

    Todo getTodoByTodoId(int todoId);

    List<Todo> getTodoByUserId(int userId,int page);

    List<Todo> getTodoByScheduleId(int scheduleId,int page);

    int setChildTodoId(int childTodoId, int parentTodoId);

    List<Todo> getChildTodos(int todoId,int page);

    List<Todo> getParentTodos(int todoId,int page);

    int getMaxTodoId();

    int deleteTodoRealationship(int childTodoId,int parentTodoId);

    List<Integer> getTodoIdsByScheduleId(int scheduleId);

    int getParentTodoNum(int todoId);

    int getChildTodoNum(int todoId);

    int getTodoNumByUserId(int userId);

    int getTodoNumByScheduleId(int scheduleId);
}
