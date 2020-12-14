package com.today.controller;

import com.today.entity.Schedule;
import com.today.service.ScheduleService;
import com.today.service.TodoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/23 20:18
 */
@RequestMapping("/schedule")
@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TodoService todoService;



    @RequestMapping(value = "/addSchedule",method = RequestMethod.POST)
    public int addSchedule(@RequestBody Schedule schedule){
        int temp=scheduleService.getMaxScheduleId();
        schedule.setScheduleId(temp+1);
        return scheduleService.addSchedule(schedule);
    }

    @RequestMapping(value = "/deleteScheduleByScheduleId/{scheduleId}",method = RequestMethod.DELETE)
    public int deleteScheduleByScheduleId(@PathVariable("scheduleId") int scheduleId){
        todoService.deleteTodoByScheduleId(scheduleId);
        return scheduleService.deleteScheduleByScheduleId(scheduleId);
    }

    @RequestMapping(value = "/deleteScheduleByUserId/{userId}",method = RequestMethod.DELETE)
    public int deleteScheduleByUserId(@PathVariable("userId") int userId){
        todoService.deleteTodoByUserId(userId);
        return scheduleService.deleteScheduleByUserId(userId);
    }

    @RequestMapping(value = "/updateSchedule",method = RequestMethod.PUT)
    public int updateSchedule(@RequestBody Schedule schedule){
        return scheduleService.updateSchedule(schedule);
    }

    @RequestMapping(value = "/getScheduleByScheduleId/{scheduleId}",method = RequestMethod.GET)
    public Schedule getScheduleByScheduleId(@PathVariable("scheduleId") int scheduleId){
        return scheduleService.getScheduleByScheduleId(scheduleId);
    }

    @RequestMapping(value = "/getScheduleByUserId/{userId}",method = RequestMethod.GET)
    public List<Schedule> getScheduleByUserId(@PathVariable("userId") int userId){
        return scheduleService.getScheduleByUserId(userId);
    }
}
