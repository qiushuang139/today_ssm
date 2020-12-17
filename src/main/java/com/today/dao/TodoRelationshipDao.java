package com.today.dao;

import com.today.entity.TodoRelationship;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/24 15:16
 */
public interface TodoRelationshipDao {
    int addTodoRealationShip(TodoRelationship todoRelationship);

    List<Integer> getChildTodoIdList(@Param("todoId") int todoId,
                                     @Param("page")int page,@Param("pageSize")int pageSize);

    List<Integer> getParentTodoIdList(@Param("todoId")int todoId,
                                      @Param("page") int page,@Param("pageSize") int pageSize);

    int deleteTodoRelationshipByTodoId(@Param("todoId") int todoId);

    int deleteTodoRealationshipByBothTodoId(@Param("childTodoId") int childTodoId,
                                            @Param("parentTodoId") int parentTodoId);

    int getParentTodoNum(@Param("todoId") int todoId);

    int getChildTodoNum(@Param("todoId") int todoId);
}
