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

import com.today.dao.WorkLogDao;
import com.today.entity.WorkLog;
import com.today.service.WorkLogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class WorkLogServiceImpl implements WorkLogService {
    @Autowired
    private WorkLogDao workLogDao;

    @Override
    public int addWorkLog(WorkLog workLog) {
        return workLogDao.addWorkLog(workLog);
    }

    @Override
    public int deleteWorkLogByDate(int userId, Date date) {
        return workLogDao.deleteWorkLogByDate(userId,date);
    }

    @Override
    public int updateWorkLog(WorkLog workLog) {
        return workLogDao.updateWorkLog(workLog);
    }

    @Override
    public WorkLog getWorkLogByDate(int userId, String date) {
        return workLogDao.getWorkLogByDate(userId,date);
    }

    @Override
    public List<WorkLog> getWorkLogByUserID(int userId, int page, int pageSize) {
        return workLogDao.getWorkLogByUserID(userId,page,pageSize);
    }

    public void setWorkLogDao(WorkLogDao workLogDao) {
        this.workLogDao=workLogDao;
    }
}
