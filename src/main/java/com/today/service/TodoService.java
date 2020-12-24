package com.today.service;

import com.today.entity.Todo;
import org.apache.ibatis.annotations.Param;

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


    int deleteTodoRelationshipByTodoId(int todoId);

    Todo getTodoByTodoId(int todoId);

    List<Todo> getTodoByUserId(int userId,int page,int pageSize);

    List<Todo> getTodoByScheduleId(int scheduleId,int page,int pageSize);
    List<Todo>getTodoBypriority( int priority,int page,int pageSize);
    List<Todo>getTodoBytype(int todoType, int page, int pageSize);
    List<Todo>getTodoBystate(int todoState, int page, int pageSize);
    int setChildTodoId(int childTodoId, int parentTodoId);

    List<Todo> getChildTodos(int todoId,int page,int pageSize);

    List<Todo> getParentTodos(int todoId,int page,int pageSize);

    int getMaxTodoId();

    int deleteTodoRelationship(int childTodoId, int parentTodoId);

    List<Integer> getTodoIdsByScheduleId(int scheduleId);

    int getParentTodoNum(int todoId);

    int getChildTodoNum(int todoId);

    int getTodoNumByUserId(int userId);

    int getTodoNumByScheduleId(int scheduleId);
}
