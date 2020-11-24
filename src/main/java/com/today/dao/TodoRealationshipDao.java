package com.today.dao;

import com.today.entity.TodoRealationship;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/24 15:16
 */
public interface TodoRealationshipDao {
    int addTodoRealationShip(TodoRealationship todoRealationship);

    List<Integer> getChildTodoIdList(@Param("todoId") int todoId);

    List<Integer> getParentTodoIdList(@Param("todoId")int todoId);

    int deleteTodoRealationship(int todoId);
}
