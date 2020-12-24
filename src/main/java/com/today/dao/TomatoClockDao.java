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
    int setTomatoClockState(@Param("tomatoClockId")int tomatoClockId, @Param("type")int type);
    //中止番茄钟
    int overTomatoClock(@Param("tomatoId")int tomatoId);
    //暂停番茄钟 PUT方法
    int sleepTomatoClock(@Param("tomatoId")int tomatoId);
    //根据userId获取所有的tomatoclock
    List<TomatoClock> getTomatoClockByUserId(@Param("userId")int userId,
                                             @Param("page")int page,@Param("pagesize")int pagesize);
    //根据tomatoClockID获取对应番茄钟
    TomatoClock getTomatoClockById(@Param("tomatoClockId")int tomatoClockId);
    //得到最大番茄钟ID
    int getTomatoClockId();
    //根据tomatoClockID删除对应的tomatoclock
    int deleteTomatoClockByTomatoClockId(@Param("tomatoClockId") int tomatoClockId);
    //根据userID删除对应的tomatoclock
    int deleteTomatoClockByUserId(@Param("userId") int userId);
    //编辑工作心得
    int setSummary(@Param("userId") int userId,@Param("summary") String summary);

}
