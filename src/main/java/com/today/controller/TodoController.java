package com.today.controller;

import com.today.component.annotation.Authorization;
import com.today.entity.Todo;
import com.today.model.ResultModel;
import com.today.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :zhangyi
 * @description:关于todo控制的函数
 * @date :2020/11/18 16:10
 */

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     * @description: 添加待办事项
     * @param todo 将要添加的待办事项
     * @return:int 0:添加失败，1:添加成功
    */
    @RequestMapping(method = RequestMethod.POST)
    @Authorization
    public ResponseEntity addTodo(@RequestBody Todo todo){
        try {
            int todoId=todoService.getMaxTodoId()+1;
            todo.setTodoId(todoId);
            todoService.addTodo(todo);
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,todoService.getTodoByTodoId(todoId)),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * @description:修改待办事项的信息
     * @param todo 将要修改的todo
     * @return:int 0:修改失败，1:修改成功
    */
    @RequestMapping(method = RequestMethod.PUT)
    @Authorization
    public ResponseEntity updateTodo(@RequestBody Todo todo){
        try {
            todoService.updateTodo(todo);
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,todoService.getTodoByTodoId(todo.getTodoId())),
                    HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @description:根据todoId删除todo
     * @param todoId 将要删除的todoId
     * @return:int 0:删除失败，1:删除成功
    */
    @RequestMapping(value = "/{todoId}",method = RequestMethod.DELETE)
    @Authorization
    public ResponseEntity deleteTodo(@PathVariable("todoId")int todoId){
        try {
            if(todoService.deleteTodoByTodoId(todoId)>=1){
                return new ResponseEntity(new ResultModel(HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(new ResultModel(HttpStatus.NOT_FOUND,todoId),HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @description: 根据todoList批量删除Todo
     * @param todoIdList
     * @return:int 0:删除失败 >1:删除的Todo数量
    */
    @RequestMapping(value = "/delete-todo-by-todoid-list",method = RequestMethod.DELETE)
    public ResponseEntity deleteTodoByTodoIdList(@RequestBody List<Integer> todoIdList){
        try {
            for (Integer todoId : todoIdList) {
                todoService.deleteTodoRealationshipByTodoId(todoId);
                todoService.deleteTodoByTodoId(todoId);
            }
            return new ResponseEntity(new ResultModel(HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * @description:根据TodoId获取Todo
     * @param todoId
     * @return:com.today.entity.Todo
    */
    @Authorization
    @RequestMapping(value = "/{todoId}",method = RequestMethod.GET)
    public ResponseEntity getTodoByTodoId(@PathVariable("todoId") int todoId){
        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,todoService.getTodoByTodoId(todoId)),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * @description: 根据userId获取Todo
     * @param
     * @return:java.util.List<com.today.entity.Todo>批量获取到的Todo
    */
    @RequestMapping(value = "/get-todo-by-userid/{userId}",method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getTodoByUserId(@PathVariable("userId") int userId,int page){
        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,todoService.getTodoByUserId(userId,page)),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @RequestMapping(value = "/get-todonum-by-userid/{userId}",method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getTodoNumByUserId(@PathVariable("userId") int userId){
        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,todoService.getTodoNumByUserId(userId)),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    /**
     * @description:根据ScheduleId获取Todo
     * @param scheduleId 待获取的scheduleId
     * @return:java.util.List<com.today.entity.Todo> 批量获取到的Todo
    */
    @Authorization
    @RequestMapping(value = "/get-todo-by-scheduleid/{scheduleId}",method = RequestMethod.GET)
    public ResponseEntity getTodoNumByScheduleId(@PathVariable("scheduleId")int scheduleId,int page){
        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,todoService.getTodoByScheduleId(scheduleId,page)),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/get-todonum-by-scheduleid/{scheduleId}",method = RequestMethod.GET)
    public ResponseEntity getTodoByScheduleId(@PathVariable("scheduleId")int scheduleId){
        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,todoService.getTodoNumByScheduleId(scheduleId)),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @description:根据todoId获取子待办事项
     * @param todoId todoId
     * @return:java.util.List<com.today.entity.Todo> 批量获取的Todo
     */
    @RequestMapping(value = "/get-child-todo/{todoId}",method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getChildTodos(@PathVariable("todoId") int todoId,int page){
        try {
            return new ResponseEntity(new ResultModel(HttpStatus.OK,todoService.getChildTodos(todoId,page)),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * @description:根据TodoId获取父待办事项
     * @param todoId
     * @return:java.util.List<com.today.entity.Todo> 批量获取的Todo
     */
    @RequestMapping(value = "/get-parent-todo/{todoId}",method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getParentTodos(@PathVariable("todoId") int todoId,int page){
        try {
            return new ResponseEntity(new ResultModel(HttpStatus.OK,todoService.getParentTodos(todoId,page)),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/get-parent-todonum/{todoId}",method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getParentTodoNum(@PathVariable("todoId")int todoId){
        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,todoService.getParentTodoNum(todoId)),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/get-child-todonum/{todoId}",method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getChildTodoNum(@PathVariable("todoId")int todoId){
        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,todoService.getChildTodoNum(todoId)),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
