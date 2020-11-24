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

    int deleteTodoByUserId(int userId);

    int deleteTodoByScheduleId(int scheduleId);

    int deleteTodoRealationshipByTodoId(int todoId);

    Todo getTodoByTodoId(int todoId);

    List<Todo> getTodoByUserId(int userId);

    List<Todo> getTodoByScheduleId(int scheduleId);

    int setChildTodoId(int childTodoId, int parentTodoId);

    List<Todo> getChildTodos(int todoId);

    List<Todo> getParentTodos(int todoId);

    int getMaxTodoId();
}
