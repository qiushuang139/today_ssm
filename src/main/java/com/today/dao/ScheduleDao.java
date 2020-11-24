package com.today.dao;

import com.today.entity.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/11/23 19:48
 */
public interface ScheduleDao {
    int addSchedule(Schedule schedule);

    int deleteScheduleByScheduleId(@Param("scheduleId") int scheduleId);

    int deleteScheduleByUserId(@Param("userId")int userId);

    int updateSchedule(Schedule schedule);

    Schedule getScheduleByScheduleId(@Param("scheduleId")int scheduleId);

    List<Schedule> getScheduleByUserId(@Param("userId")int userId);

    int getMaxScheduleId();
}
