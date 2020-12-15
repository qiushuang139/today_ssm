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
   Map<Date,String> getRecord(@Param("tomatoClockID") int tomatoClockID);
    //生成工作日志
    int generateDiary(@Param("tomatoClockID")int tomatoClockID);
   Date gettime(int tomatoClockID);
    String  getstatetype(int tomatoClockID);
}
