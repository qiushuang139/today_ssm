package com.today.service.impl;

import com.today.dao.ScheduleDao;
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

    @Override
    public int addSchedule(Schedule schedule) {
        return scheduleDao.addSchedule(schedule);
    }

    @Override
    public int deleteScheduleByScheduleId(int scheduleId) {
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
    public List<Schedule> getScheduleByUserId(int userId) {
        return scheduleDao.getScheduleByUserId(userId);
    }

    @Override
    public int getMaxScheduleId() {
        return scheduleDao.getMaxScheduleId();
    }

    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao=scheduleDao;
    }


}
