/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TomatoCLock
 * Author:   liyou
 * Date:     2020/11/18 18:52
 * Description: tomatoclock实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈tomatoclock实体类〉
 *
 * @author liyou
 * @create 2020/11/18
 * @author liyou
 * @create 2020/11/18
 * @since 1.0.0
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈tomatoclock实体类〉
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈tomatoclock实体类〉
 *
 * @author liyou
 * @create 2020/11/18
 * @since 1.0.0
 */
package com.today.entity;

import java.util.Date;

public class TomatoClock {

    //用户ID
    private int userId;
    //番茄钟
    private int tomatoClockId;
    //待办ID
    protected int todoId;
    //类型
    private int type;
    //单次时间
    private int singleDuration;
    //单次休息时长
    private int singleRestDuration;
    //开始时间
    private Date beginTime;
    //预计重复次数
    private int repeatTimes;
    //小结
    protected String summary;
    //bgm
    private String bgmUrl;

    public int getTomatoClockId() {
        return tomatoClockId;
    }

    public void setTomatoClockId(int tomatoClockId) {
        this.tomatoClockId = tomatoClockId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public int getSingleDuration() {
        return singleDuration;
    }

    public void setSingleDuration(int singleDuration) {
        this.singleDuration = singleDuration;
    }


    public int getSingleRestDuration() {
        return singleRestDuration;
    }

    public void setSingleRestDuration(int singleRestDuration) {
        this.singleRestDuration = singleRestDuration;
    }


    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public int getRepeatTimes() {
        return repeatTimes;
    }

    public void setRepeatTimes(int repeatTimes) {
        this.repeatTimes = repeatTimes;
    }


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBgmUrl() {
        return bgmUrl;
    }

    public void setBgmUrl(String bgmUrl) {
        this.bgmUrl = bgmUrl;
    }


}
