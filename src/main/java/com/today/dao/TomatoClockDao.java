package com.today.dao;

import com.today.entity.Todo;
import com.today.entity.TomatoClock;
import org.apache.ibatis.annotations.Param;


public interface TomatoClockDao {

    //新增番茄钟
    int addTomatoClock(TomatoClock tomatoCLock);

    int updateTomatoClock(TomatoClock tomatoCLock);

    int SetTomatoClockState(TomatoClock tomatoCLock, Todo todo);

    int OverTomatoClock(TomatoClock tomatoCLock);

    int SleepTomatoClock(TomatoClock tomatoCLock);

    TomatoClock getTomatoClockById(@Param("tomatoClockID")int tomatoClockID);

    int getTomatoClockId();
}
