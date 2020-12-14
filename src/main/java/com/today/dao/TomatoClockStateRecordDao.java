package com.today.dao;

import com.today.entity.TomatoClockStateRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TomatoClockStateRecordDao {
    //新增总结
    String getSummry(TomatoClockStateRecord tomatoClockStateRecord);
    //得到对应用户的番茄钟使用记录
   Map<Date,String> getRecord(@Param("userId") int userId);
    //生成工作日志
    int generateDiary(@Param("userId")int userId);
   Date gettime(int userId);
    String  getstatetype(int userId);
}
