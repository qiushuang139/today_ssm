package com.today.controller;

import com.today.component.annotation.Authorization;
import com.today.entity.Schedule;
import com.today.model.ResultModel;
import com.today.service.ScheduleService;
import com.today.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author :zhangyi
 * @description:与日程相关的控制类
 * @date :2020/11/23 20:18
 */
@RequestMapping("/schedules")
@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TodoService todoService;


    /**
     * @description:添加日程
     * @param schedule 将要添加的日程
     * @return: 0:添加失败，1:添加成功
    */
    @RequestMapping(method = RequestMethod.POST)
    @Authorization
    public ResponseEntity addSchedule(@RequestBody Schedule schedule){
        try {
            int temp = scheduleService.getMaxScheduleId()+1;
            schedule.setScheduleId(temp);
            scheduleService.addSchedule(schedule);
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,scheduleService.getScheduleByScheduleId(temp)),
                    HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @description:根据scheduleId删除日程
     * @param scheduleId 将要删除的ScheduleId
     * @return:int 0:删除失败，1:删除成功
    */
    @RequestMapping(value = "/{scheduleId}",method = RequestMethod.DELETE)
    @Authorization
    public ResponseEntity deleteScheduleByScheduleId(@PathVariable("scheduleId") int scheduleId){
        try {
            scheduleService.deleteScheduleByScheduleId(scheduleId);//删除Schedule
            return new ResponseEntity(new ResultModel(HttpStatus.NO_CONTENT),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @description:更新日程
     * @param schedule 将要更新的schedule
     * @return:int 0:修改失败，>1:修改成功
     */
    @RequestMapping(method = RequestMethod.PUT)
    @Authorization
    public ResponseEntity updateSchedule(@RequestBody Schedule schedule){
        try {
            scheduleService.updateSchedule(schedule);
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK, scheduleService.getScheduleByScheduleId(schedule.getScheduleId())),
                    HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * @description: 根据schedule获取Schedule
     * @param scheduleId 将要获取的scheduleId
     * @return:com.today.entity.Schedule 获取的Schedule
     */
    @RequestMapping(value = "/{scheduleId}",method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getScheduleByScheduleId(@PathVariable("scheduleId") int scheduleId){
        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,scheduleService.getScheduleByScheduleId(scheduleId)),
                    HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @description:根据userId批量获取Schedule
     * @param userId 将要获取的userId
     * @return:java.util.List<com.today.entity.Schedule> 获取到的Schedule
     */
    @RequestMapping(value = "/get-schedule-by-userid/{userId}",method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getScheduleByUserId(@PathVariable("userId") int userId,int page){
        try {
            return new ResponseEntity(new ResultModel(
                    HttpStatus.OK,scheduleService.getScheduleByUserId(userId,page)),
                    HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/get-schedulenum-by-userid/{userId}",method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getScheduleNumByUserId(@PathVariable("userId")int userId){
        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,scheduleService.getScheduleNumByUserId(userId)),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
