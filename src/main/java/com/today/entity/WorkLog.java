/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: WordLog
 * Author:   liyou
 * Date:     2020/12/17 11:12
 * Description: 工作日志
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈工作日志〉
 *
 * @author liyou
 * @create 2020/12/17
 * @author liyou
 * @create 2020/12/17
 * @since 1.0.0
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈工作日志〉
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈工作日志〉
 *
 * @author liyou
 * @create 2020/12/17
 * @since 1.0.0
 */
package com.today.entity;

import java.util.Date;

public class WorkLog {
    //用户ID
    private int userId;
    //日期
    private Date date;
    //番茄钟得分
    private int tomatoScore;
    //schedule得分
    private int scheduleScore;
    //工作日志
    private String experience;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getScheduleScore() {
        return scheduleScore;
    }

    public void setScheduleScore(int scheduleScore) {
        this.scheduleScore = scheduleScore;
    }

    public int getTomatoScore() {
        return tomatoScore;
    }

    public void setTomatoScore(int tomatoScore) {
        this.tomatoScore = tomatoScore;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
