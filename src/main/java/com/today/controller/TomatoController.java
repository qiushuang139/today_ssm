/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TomatoController
 * Author:   liyou
 * Date:     2020/11/25 15:45
 * Description: 番茄钟控制的函数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈番茄钟控制的函数〉
 *
 * @author liyou
 * @create 2020/11/25
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈番茄钟控制的函数〉
 *
 * @author liyou
 * @create 2020/11/25
 * @since 1.0.0
 */
package com.today.controller;

import com.today.entity.Todo;
import com.today.entity.TomatoClock;
import com.today.service.TodoService;
import com.today.service.TomatoClockService;
import com.today.service.TomatoClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tomato")
public class TomatoController {
@Autowired
private TodoService todoService;
    //  @Qualifier("tomatoClockService")

    private TomatoClockService tomatoClockService;

    /**
     * @param tomatoClock
     * @Date
     * @return:int
     */
    @RequestMapping("/addTomato")
    public int addTomatoClock(@RequestBody TomatoClock tomatoClock) {
        int tomatoId = tomatoClockService.getTomatoClockID() + 1;
        tomatoClock.setTomatoClockID(tomatoId);
        return tomatoClockService.addTomatoClock(tomatoClock) + 1;
    }

    /**
     * @param tomatoClock
     * @return:int
     */
    @RequestMapping("/updateTomatoClock")
    public int updateTomatoClock(@RequestBody TomatoClock tomatoClock) {
        return tomatoClockService.updateTomatoClock(tomatoClock);
    }

    /**
     * @param tomatoClock
     */
    @RequestMapping("/SetTomatoClockState")
    public int SetTomatoClockState(@RequestBody TomatoClock tomatoClock) {
        Todo todo=todoService.getTodoByTodoId(todoService.getMaxTodoId());
        return tomatoClockService.SetTomatoClockState(tomatoClock, todo);
    }

    @RequestMapping("/getTomatoClockById/{tomatoClockID}")
    public TomatoClock getTomatoClockById(int tomatoClockID) {
        return tomatoClockService.getTomatoClockById(tomatoClockID);
    }
    @RequestMapping("/SleepTomatoClock")
    public int SleepTomatoClock(TomatoClock tomatoClock) {
        return tomatoClockService.SleepTomatoClock(tomatoClock);
    }


}