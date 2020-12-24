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
 * @author liyou
 * @create 2020/11/29
 * @author liyou
 * @create 2020/11/29
 * @since 1.0.0
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈番茄钟状态变化记录表〉
 * @since 1.0.0
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈番茄钟状态变化记录表〉
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

import java.util.Date;

public class TomatoClockStateRecord {
    //状态变化时间
    private Date time;
    //状态类型
    private int stateType;
    //关联番茄钟ID
    private int tomatoClockId;

    public int getTomatoClockId() {
        return tomatoClockId;
    }


    public void setTomatoClockId(int tomatoClockId) {
        this.tomatoClockId = tomatoClockId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


    public int getStateType() {
        return stateType;
    }

    public void setStateType(int stateType) {
        this.stateType = stateType;
    }
}
