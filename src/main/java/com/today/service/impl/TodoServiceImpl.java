package com.today.service.impl;

import com.today.component.Constants;
import com.today.dao.TodoDao;
import com.today.dao.TodoRealationshipDao;
import com.today.entity.Todo;
import com.today.entity.TodoRealationship;
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
    private TodoRealationshipDao todoRealationshipDao;
    public void setTodoRealationshipDao(TodoRealationshipDao todoRealationshipDao) {
        this.todoRealationshipDao=todoRealationshipDao;
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
        todoRealationshipDao.deleteTodoRealationshipByTodoId(todoId);
        return todoDao.deleteTodoByTodoId(todoId);
    }


    @Override
    public int deleteTodoRealationshipByTodoId(int todoId) {
        return todoRealationshipDao.deleteTodoRealationshipByTodoId(todoId);
    }

    @Override
    public Todo getTodoByTodoId(int todoId) {
        return todoDao.getTodoByTodoId(todoId);
    }

    @Override
    public List<Todo> getTodoByUserId(int userId,int page) {
        return todoDao.getTodoByUserId(userId,page,Constants.TODO_PAGE_SIZE);
    }

    @Override
    public List<Todo> getTodoByScheduleId(int scheduleId,int page) {
        return todoDao.getTodoByScheduleId(scheduleId,page,Constants.TODO_PAGE_SIZE);
    }

    @Override
    public int setChildTodoId(int childTodoId, int parentTodoId) {
        TodoRealationship realationship=new TodoRealationship();
        realationship.setChildTodoId(childTodoId);
        realationship.setParentTodoId(parentTodoId);
        return todoRealationshipDao.addTodoRealationShip(realationship);
    }

    @Override
    public List<Todo> getChildTodos(int todoId,int page) {
        List<Todo> ans=new ArrayList<>();
        List<Integer> childTodoIds=todoRealationshipDao.getChildTodoIdList(todoId,page,Constants.TODO_PAGE_SIZE);
        for (Integer childTodoId:childTodoIds) {
            ans.add(todoDao.getTodoByTodoId(childTodoId));
        }
        return ans;
    }

    @Override
    public List<Todo> getParentTodos(int todoId,int page) {
        List<Todo> ans=new ArrayList<>();
        List<Integer> parentTodoIds=todoRealationshipDao.getParentTodoIdList(todoId,page, Constants.TODO_PAGE_SIZE);
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
    public int deleteTodoRealationship(int childTodoId, int parentTodoId) {
        return todoRealationshipDao.
                deleteTodoRealationshipByBothTodoId(childTodoId,parentTodoId);
    }

    @Override
    public List<Integer> getTodoIdsByScheduleId(int scheduleId) {
        return todoDao.getTodoIdsByScheduleId(scheduleId);
    }

    @Override
    public int getParentTodoNum(int todoId) {
        return todoRealationshipDao.getParentTodoNum(todoId);
    }

    @Override
    public int getChildTodoNum(int todoId) {
        return todoRealationshipDao.getChildTodoNum(todoId);
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
