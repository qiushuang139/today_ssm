package com.today.controller;

import com.today.entity.Todo;
import com.today.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :zhangyi
 * @description:关于todo控制的函数
 * @date :2020/11/18 16:10
 */
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     * @description:
     * @date: 2020/11/24 18:53
     * @param todo
     * @return:int
    */
    @RequestMapping("/addTodo")
    public int addTodo(@RequestBody Todo todo){
        int todoId=todoService.getMaxTodoId()+1;
        todo.setTodoId(todoId);
        return todoService.addTodo(todo);
    }


    /**
     * @description:
     * @date: 2020/11/24 18:53
     * @param todo
     * @return:int
    */
    @RequestMapping("/updateTodo")
    public int updateTodo(@RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }

    /**
     * @description:
     * @date: 2020/11/24 18:54
     * @param todoId
     * @return:int
    */
    @RequestMapping("/deleteTodoByTodoId/{todoId}")
    public int deleteTodoByTodoId(@PathVariable("todoId") int todoId){
        todoService.deleteTodoRealationshipByTodoId(todoId);
        return todoService.deleteTodoByTodoId(todoId);
    }


    /**
     * @description:
     * @date: 2020/11/24 18:54
     * @param scheduleId
     * @return:int
    */
    @RequestMapping("/deleteTodoByScheduleId/{scheduleId}")
    public int deleteTodoByScheduleId(@PathVariable("scheduleId") int scheduleId){
        List<Todo> todos=todoService.getTodoByScheduleId(scheduleId);
        for (Todo todo:todos) {
            todoService.deleteTodoRealationshipByTodoId(todo.getTodoId());
        }
        return todoService.deleteTodoByScheduleId(scheduleId);
    }


    /**
     * @description:
     * @date: 2020/11/24 18:53
     * @param todoIdList
     * @return:int
    */
    @RequestMapping("/deleteTodoByTodoIdList")
    public int deleteTodoByTodoIdList(@RequestBody List<Integer> todoIdList){
        int ans=0;
        for (Integer todoId:todoIdList) {
            todoService.deleteTodoRealationshipByTodoId(todoId);
            ans+=todoService.deleteTodoByTodoId(todoId);
        }
        return ans;
    }


    /**
     * @description:
     * @date: 2020/11/24 18:53
     * @param todoId
     * @return:com.today.entity.Todo
    */
    @RequestMapping("/getTodoByTodoId/{todoId}")
    public Todo getTodoByTodoList(@PathVariable("todoId") int todoId){
        return todoService.getTodoByTodoId(todoId);
    }


    /**
     * @description:
     * @date: 2020/11/24 18:52
     * @param userId
     * @return:java.util.List<com.today.entity.Todo>
    */
    @RequestMapping("getTodoByUserId/{userId}")
    public List<Todo> getTodoByUserId(@PathVariable("userId")int userId){
        return todoService.getTodoByUserId(userId);
    }



    /**
     * @description:
     * @date: 2020/11/24 18:54
     * @param scheduleId
     * @return:java.util.List<com.today.entity.Todo>
    */
    @RequestMapping("getTodoByScheduleId/{scheduleId}")
    public List<Todo> getTodoByScheduleId(@PathVariable("scheduleId")int scheduleId){
        return todoService.getTodoByScheduleId(scheduleId);
    }


    /**
     * @description:
     * @date: 2020/11/24 18:54
     * @param childTodoId
     * @param parentTodoId
     * @return:int
    */
    @RequestMapping("/setChildTodoId")
    public int setChildTodoId(int childTodoId,int parentTodoId){
        return todoService.setChildTodoId(childTodoId,parentTodoId);
    }


    /**
     * @description:
     * @date: 2020/11/24 18:54
     * @param todoId
     * @return:java.util.List<com.today.entity.Todo>
    */
    @RequestMapping("/getChildTodos")
    public List<Todo> getChildTodos(int todoId){
        return todoService.getChildTodos(todoId);
    }


    /**
     * @description:
     * @date: 2020/11/24 18:54
     * @param todoId
     * @return:java.util.List<com.today.entity.Todo>
    */
    @RequestMapping("/getParentTodos")
    public List<Todo> getParentTodos(int todoId){
        return todoService.getParentTodos(todoId);
    }


}
