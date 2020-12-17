package com.today.dao;

import com.today.entity.Todo;
import com.today.entity.TomatoClock;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TomatoClockDao {

    //新增番茄钟
    int addTomatoClock(TomatoClock tomatoCLock);
    //修改番茄钟的设置（初始化）
    int updateTomatoClock(TomatoClock tomatoCLock);
    //设置番茄钟的状态
    int SetTomatoClockState (@Param("tomatoClockID")int tomatoClockID,@Param("type")int type);
    //中止番茄钟
    int OverTomatoClock(TomatoClock tomatoCLock);
    //暂停番茄钟 PUT方法
    int SleepTomatoClock(TomatoClock tomatoCLock);
    //根据userId获取所有的tomatoclock
    List<TomatoClock> getTomatoClockByUserId(@Param("userID")int userID,
                                             @Param("page")int page,@Param("pagesize")int pagesize);
    //根据tomatoClockID获取对应番茄钟
    TomatoClock getTomatoClockById(@Param("tomatoClockID")int tomatoClockID);
    //得到最大番茄钟ID
    int getTomatoClockId();
    //根据tomatoClockID删除对应的tomatoclock
    int deleteTomatoClockByTomatoClockId(@Param("tomatoClockID") int tomatoClckID);
    //根据userID删除对应的tomatoclock
    int deleteTomatoClockByuserID(@Param("userID") int userID);
    //编辑工作心得
    int setSummary(@Param("userID") int userID,@Param("summary") String summary);

}
