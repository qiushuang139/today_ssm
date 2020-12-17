package com.today.dao;

import com.today.entity.WorkLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface LogDao {
    //生成工作日志
    int addLog(WorkLog workLog);
    //根据日期删除工作日志
    int deleteLogByDate(@Param("date")Date date);
    //更改工作日志
    int updateLog(WorkLog workLog);
    //查找工作日志
    WorkLog getLogByDate(@Param("date") Date date);
}
