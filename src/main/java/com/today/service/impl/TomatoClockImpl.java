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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TomatoClockImpl implements TomatoClockService{
    @Autowired
    private TodoDao todoDao;
    @Autowired
    private TomatoClockDao TomatoClockDao;

    @Override
    public int addTomatoClock(TomatoClock tomatoClock) {
        return TomatoClockDao.addTomatoClock(tomatoClock);
    }

    @Override
    public int updateTomatoClock(TomatoClock tomatoClock) {
        return TomatoClockDao.updateTomatoClock(tomatoClock);
    }

    @Override
    public int SetTomatoClockState(TomatoClock tomatoClock, Todo todo) {
        return TomatoClockDao.SetTomatoClockState(tomatoClock,todo);
    }

    @Override
    public int OverTomatoClock(TomatoClock tomatoClock) {
        return TomatoClockDao.OverTomatoClock(tomatoClock);
    }

    @Override
    public TomatoClock getTomatoClockById(int tomatoClockID) {
        return TomatoClockDao.getTomatoClockById(tomatoClockID);
    }

    @Override
    public int SleepTomatoClock(TomatoClock tomatoClock) {
        return TomatoClockDao.SleepTomatoClock(tomatoClock);
    }

    @Override
    public int getTomatoClockID() {
        return TomatoClockDao.getTomatoClockId();
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
        this.TomatoClockDao = tomatoClockDao;
    }
//
//   public TomatoClockDao getTomatoClockDao() {
//    return 0;
//    }
}
