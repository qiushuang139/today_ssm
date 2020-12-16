package com.today.service;

import com.today.entity.Todo;
import com.today.entity.TomatoClock;
import org.apache.ibatis.annotations.Param;

public interface TomatoClockService {
    //新增番茄钟
    int addTomatoClock(TomatoClock tomatoClock);
    //修改番茄钟的设置（初始化）
    int updateTomatoClock(TomatoClock tomatoClock);
    //设置番茄钟的状态
    int SetTomatoClockState(TomatoClock tomatoClock);
    //中止番茄钟
    int OverTomatoClock(TomatoClock tomatoClock);
    //根据tomatoClockID获取对应番茄钟
    TomatoClock getTomatoClockById(int tomatoClockID);
    //暂停番茄钟 PUT方法
    int SleepTomatoClock(TomatoClock tomatoClock);
    //得到最大番茄钟ID
    int getTomatoClockID();
    //根据tomatoClockID删除对应的tomatocloc
    int deleteTomatoClockByTomatoClockId(int tomatoClockID);
    //根据userID删除对应的tomatoclock
    int deleteTomatoClockByuserID(int userID);
    //编辑工作心得
    int setSummary(@Param("userID") int userID);
}
