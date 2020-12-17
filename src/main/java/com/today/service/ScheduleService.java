package com.today.service;

import com.today.entity.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/23 20:05
 */
public interface ScheduleService {
    int addSchedule(Schedule schedule);

    int deleteScheduleByScheduleId(int scheduleId);

    int deleteScheduleByUserId(int userId);

    int updateSchedule(Schedule schedule);

    Schedule getScheduleByScheduleId(int scheduleId);

    List<Schedule> getScheduleByUserId(int userId,int page,int pageSize);

    int getMaxScheduleId();

    int getScheduleNumByUserId(int userId);
}
