/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TomatoCLockImpl
 * Author:   liyou
 * Date:     2020/11/18 19:26
 * Description: 番茄钟实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈番茄钟实现类〉
 *
 * @author liyou
 * @create 2020/11/18
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈番茄钟实现类〉
 *
 * @author liyou
 * @create 2020/11/18
 * @since 1.0.0
 */
package com.today.service.impl;

import com.today.dao.TodoDao;
import com.today.dao.TomatoClockDao;
import com.today.entity.Todo;
import com.today.entity.TomatoClock;
import com.today.service.TomatoClockService;
import com.today.service.TomatoClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TomatoClockImpl implements TomatoClockService{
    @Autowired
    private TodoDao todoDao;
    @Autowired
    private TomatoClockDao tomatoClockDao;

    @Override
    public int addTomatoClock(TomatoClock tomatoClock) {
        return tomatoClockDao.addTomatoClock(tomatoClock);
    }

    @Override
    public int updateTomatoClock(TomatoClock tomatoClock) {
        return tomatoClockDao.updateTomatoClock(tomatoClock);
    }

    @Override
    public int SetTomatoClockState(TomatoClock tomatoClock, Todo todo) {
        return tomatoClockDao.SetTomatoClockState(tomatoClock,todo);
    }

    @Override
    public int OverTomatoClock(TomatoClock tomatoClock) {
        return tomatoClockDao.OverTomatoClock(tomatoClock);
    }

    @Override
    public TomatoClock getTomatoClockById(int tomatoClockID) {
        return tomatoClockDao.getTomatoClockById(tomatoClockID);
    }

    @Override
    public int SleepTomatoClock(TomatoClock tomatoClock) {
        return tomatoClockDao.SleepTomatoClock(tomatoClock);
    }

    @Override
    public int getTomatoClockID() {
        return tomatoClockDao.getTomatoClockId();
    }

//    @Override
//    public int getTomatoClockID() {
//        return tomatoClockDao.getTomatoClockById(tomatoClockID);
//    }

//     @Override
//        public int SleepTomatoClock(TomatoClock tomatoClock) {
//        return 0;
//    }

    public void setTomatoClockDao(TomatoClockDao tomatoClockDao) {
        this.tomatoClockDao = tomatoClockDao;
    }
//
//   public TomatoClockDao getTomatoClockDao() {
//    return 0;
//    }
}
