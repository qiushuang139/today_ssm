package com.today.service;

import com.today.entity.TomatoClockStateRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Map;

public interface TomatoClockStateRecordService {
    String getSummry();

    //得到对应用户的番茄钟使用记录
    Map<Date, String> getRecord(@Param("userId") int userId);

    //生成工作日志
    int generateDiary(@Param("userId") int userId);

}
