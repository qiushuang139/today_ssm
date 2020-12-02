/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TomatoClockStateRecord
 * Author:   liyou
 * Date:     2020/11/29 11:45
 * Description: 番茄钟状态变化记录表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈番茄钟状态变化记录表〉
 *
 * @author liyou
 * @create 2020/11/29
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈番茄钟状态变化记录表〉
 *
 * @author liyou
 * @create 2020/11/29
 * @since 1.0.0
 */
package com.today.entity;

import java.util.Map;

public class TomatoClockStateRecord extends  TomatoClock {
//状态类型
     private int statetype;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    //状态变化时间
    private int time;
    //关联番茄钟ID
    private int tomatoClockID;

    public int getStatetype() {
        return statetype;
    }

    public void setStatetype(int statetype) {
        this.statetype = statetype;
    }

    //
    public TomatoClockStateRecord( ){

    }
    //生成工作日志
    public String getSummry()  {
        return super.summry;
    }

    public void setSummry(String summry) {
        super.summry = summry;
    }

}
