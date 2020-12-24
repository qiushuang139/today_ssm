package com.today.service;

import com.today.entity.Todo;
import com.today.entity.TomatoClock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TomatoClockService {
    //新增番茄钟
    int addTomatoClock(TomatoClock tomatoClock);
    //修改番茄钟的设置（初始化）
    int updateTomatoClock(TomatoClock tomatoClock);
    //设置番茄钟的状态
    int setTomatoClockState(int tomatoClockId, int type);
    //中止番茄钟
    int overTomatoClock(int tomatoId);
    //根据tomatoClockID获取对应番茄钟
    TomatoClock getTomatoClockById(int tomatoClockId);
    //暂停番茄钟 PUT方法
    int sleepTomatoClock(int tomatoClockId);
    //得到最大番茄钟ID
    int getTomatoClockID();
    //根据tomatoClockID删除对应的tomatocloc
    int deleteTomatoClockByTomatoClockId(int tomatoClockId);
    //根据userID删除对应的tomatoclock
    int deleteTomatoClockByUserID(int userId);
    //编辑工作心得
    int setSummary(int userId,String summary);
    //根据user ID获取tomatoclock
  List<TomatoClock> getTomatoClockByUserId(int userId,int page,int pageSize);
   //根据UserID获取对应的tomatoclock记录
    List<TomatoClock> getRecordByUserId(int userId);
}
