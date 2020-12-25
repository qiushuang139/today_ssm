package com.today.service.impl;

import com.today.dao.TodoDao;
import com.today.dao.TodoRelationshipDao;
import com.today.entity.Todo;
import com.today.entity.TodoRelationship;
import com.today.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/18 11:11
 */

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;
    public void setTodoDao(TodoDao todoDao) {
        this.todoDao=todoDao;
    }

    @Autowired
    private TodoRelationshipDao todoRelationshipDao;
    public void setTodoRelationshipDao(TodoRelationshipDao todoRelationshipDao) {
        this.todoRelationshipDao = todoRelationshipDao;
    }

    @Override
    public int addTodo(Todo todo) {
        return todoDao.addTodo(todo);
    }

    @Override
    public int updateTodo(Todo todo) {
        return todoDao.updateTodoByTodoId(todo);
    }

    @Override
    public int deleteTodoByTodoId(int todoId) {
        todoRelationshipDao.deleteTodoRelationshipByTodoId(todoId);
        return todoDao.deleteTodoByTodoId(todoId);
    }


    @Override
    public int deleteTodoRelationshipByTodoId(int todoId) {
        return todoRelationshipDao.deleteTodoRelationshipByTodoId(todoId);
    }

    @Override
    public Todo getTodoByTodoId(int todoId) {
        return todoDao.getTodoByTodoId(todoId);
    }

    @Override
    public List<Todo> getTodoByUserId(int userId,int page,int pageSize) {
        return todoDao.getTodoByUserId(userId,page,pageSize);
    }

    @Override
    public List<Todo> getTodoByScheduleId(int scheduleId,int page,int pageSize) {
        return todoDao.getTodoByScheduleId(scheduleId,page,pageSize);
    }

    @Override
    public List<Todo> getTodoBypriority(int priority, int page, int pageSize) {
        return todoDao.getTodoBypriority(priority,page,pageSize);
    }

    @Override
    public List<Todo> getTodoBytype(int todoType, int page, int pageSize) {
        return todoDao.getTodoBytype(todoType, page, pageSize);
    }

    @Override
    public List<Todo> getTodoByMohu(Integer todoState, Integer priority,Integer todoType,int page, int pageSize) {
        List<Todo> list=todoDao.getTodoByMohu(todoState, priority, todoType, page, pageSize);
        return list;
        //return todoDao.getTodoByMohu(todoState,priority,todoType,page,pageSize);
    }

    @Override
    public int setChildTodoId(int childTodoId, int parentTodoId) {
        TodoRelationship relationship=new TodoRelationship();
        relationship.setChildTodoId(childTodoId);
        relationship.setParentTodoId(parentTodoId);
        return todoRelationshipDao.addTodoRelationShip(relationship);
    }

    @Override
    public List<Todo> getChildTodos(int todoId,int page,int pageSize) {
        List<Todo> ans=new ArrayList<>();
        List<Integer> childTodoIds= todoRelationshipDao.getChildTodoIdList(todoId,page,pageSize);
        for (Integer childTodoId:childTodoIds) {
            ans.add(todoDao.getTodoByTodoId(childTodoId));
        }
        return ans;
    }

    @Override
    public List<Todo> getParentTodos(int todoId,int page,int pageSize) {
        List<Todo> ans=new ArrayList<>();
        List<Integer> parentTodoIds= todoRelationshipDao.getParentTodoIdList(todoId,page,pageSize);
        for (Integer parentTodoId:parentTodoIds) {
            ans.add(todoDao.getTodoByTodoId(parentTodoId));
        }
        return ans;
    }

    @Override
    public int getMaxTodoId() {
        return todoDao.getMaxTodoId();
    }

    @Override
    public int deleteTodoRelationship(int childTodoId, int parentTodoId) {
        return todoRelationshipDao.
                deleteTodoRealationshipByBothTodoId(childTodoId,parentTodoId);
    }

    @Override
    public List<Integer> getTodoIdsByScheduleId(int scheduleId) {
        return todoDao.getTodoIdsByScheduleId(scheduleId);
    }

    @Override
    public int getParentTodoNum(int todoId) {
        return todoRelationshipDao.getParentTodoNum(todoId);
    }

    @Override
    public int getChildTodoNum(int todoId) {
        return todoRelationshipDao.getChildTodoNum(todoId);
    }

    @Override
    public int getTodoNumByUserId(int userId) {
        return todoDao.getTodoNumByUserId(userId);
    }

    @Override
    public int getTodoNumByScheduleId(int scheduleId) {
        return todoDao.getTodoNumByScheduleId(scheduleId);
    }
}
