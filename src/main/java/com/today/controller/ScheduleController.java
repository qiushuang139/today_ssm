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



    @RequestMapping("/addSchedule")
    public int addSchedule(@RequestBody Schedule schedule){
        int temp=scheduleService.getMaxScheduleId();
        schedule.setScheduleId(temp+1);
        return scheduleService.addSchedule(schedule);
    }

    @RequestMapping("/deleteScheduleByScheduleId/{scheduleId}")
    public int deleteScheduleByScheduleId(@PathVariable("scheduleId") int scheduleId){
        todoService.deleteTodoByScheduleId(scheduleId);
        return scheduleService.deleteScheduleByScheduleId(scheduleId);
    }

    @RequestMapping("/deleteScheduleByUserId/{userId}")
    public int deleteScheduleByUserId(@PathVariable("userId") int userId){
        todoService.deleteTodoByUserId(userId);
        return scheduleService.deleteScheduleByUserId(userId);
    }

    @RequestMapping("/updateSchedule")
    public int updateSchedule(@RequestBody Schedule schedule){
        return scheduleService.updateSchedule(schedule);
    }

    @RequestMapping("/getScheduleByScheduleId/{scheduleId}")
    public Schedule getScheduleByScheduleId(@PathVariable("scheduleId") int scheduleId){
        return scheduleService.getScheduleByScheduleId(scheduleId);
    }

    @RequestMapping("/getScheduleByUserId/{userId}")
    public List<Schedule> getScheduleByUserId(@PathVariable("userId") int userId){
        return scheduleService.getScheduleByUserId(userId);
    }
}
