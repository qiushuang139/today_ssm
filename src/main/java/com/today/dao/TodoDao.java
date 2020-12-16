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


    int updateTodoByTodoId(Todo todo);//根据TodoId修改Todo

    Todo getTodoByTodoId(@Param("todoId") int todoId);//根据TodoId获取Todo

    List<Todo> getTodoByUserId(@Param("userId") int userId,@Param("page") int page,
                               @Param("pageSize") int pageSize);//根据userId获取Todo列表

    List<Todo> getTodoByScheduleId(@Param("scheduleId") int scheduleId,
                                   @Param("page")int page, @Param("pageSize")int pageSize);//根据ScheduleId获取todo列表

    int getTodoNumByUserId(@Param("userId")int userId);

    int getTodoNumByScheduleId(@Param("scheduleId")int scheduleId);

    int getMaxTodoId();

    List<Integer> getTodoIdsByScheduleId(@Param("scheduleId") int scheduleId);

}
