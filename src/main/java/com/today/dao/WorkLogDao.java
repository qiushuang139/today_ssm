package com.today.dao;

import com.today.entity.WorkLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface WorkLogDao {
    //生成工作日志
    int addWorkLog(WorkLog workLog);
    //根据日期删除工作日志
    int deleteWorkLogByDate(@Param("userID") int userID, @Param("date")Date date);
    //更改工作日志
    int updateWorkLog(WorkLog workLog);
    //查找工作日志
    WorkLog getWorkLogByDate(@Param("userID") int userID, @Param("date") String date);

    List<WorkLog> getWorkLogByUserID(@Param("userID") int userID,
                                     @Param("page") int page,@Param("pageSize") int pageSize);
}
