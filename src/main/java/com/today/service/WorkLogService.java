package com.today.service;

import com.today.entity.WorkLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface WorkLogService {
    //生成工作日志
    int addWorkLog(WorkLog workLog);
    //根据日期删除工作日志
    int deleteWorkLogByDate(int userId, Date date);
    //更改工作日志
    int updateWorkLog(WorkLog workLog);
    //查找工作日志
    WorkLog getWorkLogByDate(int userId, String date);

    List<WorkLog> getWorkLogByUserID(int userId,int page,int pageSize);
}
