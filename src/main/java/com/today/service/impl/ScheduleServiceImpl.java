package com.today.service.impl;

import com.today.component.Constants;
import com.today.dao.ScheduleDao;
import com.today.dao.TodoDao;
import com.today.dao.TodoRealationshipDao;
import com.today.entity.Schedule;
import com.today.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/23 20:12
 */
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    @Autowired
    private TodoDao todoDao;

    @Autowired
    private TodoRealationshipDao todoRealationshipDao;

    @Override
    public int addSchedule(Schedule schedule) {
        return scheduleDao.addSchedule(schedule);
    }

    @Override
    public int deleteScheduleByScheduleId(int scheduleId) {
        List<Integer> todoIds=todoDao.getTodoIdsByScheduleId(scheduleId);//删除todo记录
        for(Integer id:todoIds){
                todoRealationshipDao.deleteTodoRealationshipByTodoId(id);
                todoDao.deleteTodoByTodoId(id);//删除todo
        }
        return scheduleDao.deleteScheduleByScheduleId(scheduleId);
    }

    @Override
    public int deleteScheduleByUserId(int userId) {
        return scheduleDao.deleteScheduleByUserId(userId);
    }

    @Override
    public int updateSchedule(Schedule schedule) {
        return scheduleDao.updateSchedule(schedule);
    }

    @Override
    public Schedule getScheduleByScheduleId(int scheduleId) {
        return scheduleDao.getScheduleByScheduleId(scheduleId);
    }

    @Override
    public List<Schedule> getScheduleByUserId(int userId,int page) {
        return scheduleDao.getScheduleByUserId(userId,page, Constants.SCHEDULE_PAGE_SIZE);
    }

    @Override
    public int getMaxScheduleId() {
        return scheduleDao.getMaxScheduleId();
    }

    @Override
    public int getScheduleNumByUserId(int userId) {
        return scheduleDao.getScheduleNumByUserId(userId);
    }

    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao=scheduleDao;
    }


}
