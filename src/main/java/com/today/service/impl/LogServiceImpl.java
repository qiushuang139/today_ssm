/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LogServiceImpl
 * Author:   liyou
 * Date:     2020/12/17 11:33
 * Description: 工作日志实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈工作日志实现类〉
 *
 * @author liyou
 * @create 2020/12/17
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈工作日志实现类〉
 *
 * @author liyou
 * @create 2020/12/17
 * @since 1.0.0
 */
package com.today.service.impl;

import com.today.dao.LogDao;
import com.today.entity.WorkLog;
import com.today.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public int addLog(WorkLog workLog) {
        return logDao.addLog(workLog);
    }

    @Override
    public int deleteLogByDate(Date date) {
        return logDao.deleteLogByDate(date);
    }

    @Override
    public int updateLog(WorkLog workLog) {
        return logDao.updateLog(workLog);
    }

    @Override
    public WorkLog getLogByDate(Date date) {
        return logDao.getLogByDate(date);
    }

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    public LogDao getLogDao() {
        return logDao;
    }
}
