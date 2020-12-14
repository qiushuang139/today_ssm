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

public class TomatoClock {
    public int getTomatoClockID() {
        return tomatoClockID;
    }

    public void setTomatoClockID(int tomatoClockID) {
        this.tomatoClockID = tomatoClockID;
    }
int userId;
    //番茄钟
   private int tomatoClockID;
    //待办ID
    protected int  todoID;
    //类型
    private int type ;

    public int getSingelRestDuration() {
        return singelRestDuration;
    }

    public void setSingelRestDuration(int singelRestDuration) {
        this.singelRestDuration = singelRestDuration;
    }

    //单次休息时长
    private int singelRestDuration;

    public int getBeiginTime() {
        return beiginTime;
    }

    public void setBeiginTime(int beiginTime) {
        this.beiginTime = beiginTime;
    }

    //开始时间
    private int beiginTime;

    public int getRepeatTimes() {
        return repeatTimes;
    }

    public void setRepeatTimes(int repeatTimes) {
        this.repeatTimes = repeatTimes;
    }

    //预计重复次数
    private int repeatTimes;

    public String getSummry()  {
        return summry;
    }

    public void setSummry(String summry) {
        this.summry = summry;
    }

    //小结
    protected String summry;
    //bgm
    private  String bgmUrl;
}
