package com.today.service.impl;

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

    @Autowired
    private TodoRealationshipDao todoRealationshipDao;

    @Override
    public int addTodo(Todo todo) {
        return todoDao.addTodo(todo);
    }

    @Override
    public int updateTodo(Todo todo) {
        return todoDao.updateTodoByTodoId(todo.getTodoId(),todo);
    }

    @Override
    public int deleteTodoByTodoId(int todoId) {
        return todoDao.deleteTodoByTodoId(todoId);
    }

    @Override
    public int deleteTodoByUserId(int userId) {
        return todoDao.deleteTodoByUserId(userId);
    }

    @Override
    public int deleteTodoByScheduleId(int scheduleId) {
        return todoDao.deleteTodoByScheduleId(scheduleId);
    }

    @Override
    public int deleteTodoRealationshipByTodoId(int todoId) {
        return todoRealationshipDao.deleteTodoRealationship(todoId);
    }

    @Override
    public Todo getTodoByTodoId(int todoId) {
        return todoDao.getTodoByTodoId(todoId);
    }

    @Override
    public List<Todo> getTodoByUserId(int userId) {
        return todoDao.getTodoByUserId(userId);
    }

    @Override
    public List<Todo> getTodoByScheduleId(int scheduleId) {
        return todoDao.getTodoByScheduleId(scheduleId);
    }

    @Override
    public int setChildTodoId(int childTodoId, int parentTodoId) {
        TodoRealationship realationship=new TodoRealationship();
        realationship.setChildTodoId(childTodoId);
        realationship.setParentTodoId(parentTodoId);
        return todoRealationshipDao.addTodoRealationShip(realationship);
    }

    @Override
    public List<Todo> getChildTodos(int todoId) {
        List<Todo> ans=new ArrayList<>();
        List<Integer> childTodoIds=todoRealationshipDao.getChildTodoIdList(todoId);
        for (Integer childTodoId:childTodoIds) {
            ans.add(todoDao.getTodoByTodoId(childTodoId));
        }
        return ans;
    }

    @Override
    public List<Todo> getParentTodos(int todoId) {
        List<Todo> ans=new ArrayList<>();
        List<Integer> parentTodoIds=todoRealationshipDao.getParentTodoIdList(todoId);
        for (Integer parentTodoId:parentTodoIds) {
            ans.add(todoDao.getTodoByTodoId(parentTodoId));
        }
        return ans;
    }

    @Override
    public int getMaxTodoId() {
        return todoDao.getMaxTodoId();
    }

    public void setTodoDao(TodoDao todoDao) {
        this.todoDao=todoDao;
    }

    public void setTodoRealationshipDao(TodoRealationshipDao todoRealationshipDao) {
        this.todoRealationshipDao=todoRealationshipDao;
    }
}
