/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TomatoClockStateRecordImpl
 * Author:   liyou
 * Date:     2020/11/29 11:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author liyou
 * @create 2020/11/29
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author liyou
 * @create 2020/11/29
 * @since 1.0.0
 */
package com.today.service.impl;

import com.today.dao.TomatoClockStateRecordDao;
import com.today.entity.TomatoClock;
import com.today.entity.TomatoClockStateRecord;
import org.apache.ibatis.annotations.Param;

import java.util.*;

public class TomatoClockStateRecordImpl {
    private TomatoClockStateRecordDao tomatoClockStateRecordDao;

    public void setTomatoClockStateRecordDao(TomatoClockStateRecordDao tomatoClockStateRecordDao) {
        this.tomatoClockStateRecordDao = tomatoClockStateRecordDao;
    }

    public TomatoClockStateRecordDao getTomatoClockStateRecordDao() {
        TomatoClockStateRecordDao tomatoClockStateRecordDao = null;
        return tomatoClockStateRecordDao;
    }

    //得到对应用户的番茄钟使用记录
    public Map<Date,String> getRecord(@Param("userId") int userId){
        Map<Date,String> map=new HashMap<>(){};
     map.put( tomatoClockStateRecordDao.gettime(userId),tomatoClockStateRecordDao.getstatetype(userId));
return  map;

    }

    //生成工作日志
 public  int generateDiary(@Param("userId")int userId){
return tomatoClockStateRecordDao.generateDiary(userId);
 }

}
