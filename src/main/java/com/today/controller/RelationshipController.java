package com.today.controller;

import com.today.component.annotation.Authorization;
import com.today.entity.TodoRelationship;
import com.today.model.ResultModel;
import com.today.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/12/15 20:09
 */
@RequestMapping("/relationships")
@RestController
public class RelationshipController {

    @Autowired
    private TodoService todoService;

    /**
     * @description:为Todo设置子待办事项
     * @param relationship 参数
     * @return:int 0:设置失败 1:设置成功
     */
    @RequestMapping(method = RequestMethod.POST)
    @Authorization
    public ResponseEntity addRelationship(@RequestBody TodoRelationship relationship){
        try {
            if(todoService.setChildTodoId(relationship.getChildTodoId(),relationship.getParentTodoId())>=1){
                return new ResponseEntity(new ResultModel(HttpStatus.CREATED,relationship), HttpStatus.CREATED);
            }
            return new ResponseEntity(new ResultModel(HttpStatus.NON_AUTHORITATIVE_INFORMATION),HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @description:删除一个父子待办关系
     * @param childTodoId 子todoId
     * @param parentTodoId 父todoId
     * @return: 0:添加失败,1:添加成功
     */
    @RequestMapping(value = "/delete-todo-relationship",method = RequestMethod.DELETE)
    @Authorization
    public ResponseEntity deleteTodoRelationship(int childTodoId,int parentTodoId){
        try {
            if(todoService.deleteTodoRelationship(childTodoId,parentTodoId)>=1){
                return new ResponseEntity(new ResultModel(HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(new ResultModel(HttpStatus.NON_AUTHORITATIVE_INFORMATION),HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
