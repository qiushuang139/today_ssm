package com.today.dao;

import com.today.entity.Todo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/18 11:10
 */
public interface TodoDao {
    int addTodo(Todo todo);//添加Todo

    int deleteTodoByTodoId(@Param("todoId") int todoId);//根据TodoId删除Todo

    int deleteTodoByUserId(@Param("userId")int userId);

    int deleteTodoByScheduleId(@Param("scheduleId")int scheduleId);

    int updateTodoByTodoId(@Param("todoId") int todoId,Todo todo);//根据TodoId修改Todo

    Todo getTodoByTodoId(@Param("todoId") int todoId);//根据TodoId获取Todo

    List<Todo> getTodoByUserId(@Param("userId") int userId);//根据userId获取Todo列表

    List<Todo> getTodoByScheduleId(@Param("scheduleId") int scheduleId);//根据ScheduleId获取todo列表

    int getTodoNumberByUserId(@Param("userId")int userId);

    int getTodoNumberByScheduleId(@Param("scheduleId")int scheduleId);

    int getMaxTodoId();
}
