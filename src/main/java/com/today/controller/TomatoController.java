/**
 *
 * FileName: TomatoController
 * Author:   liyou
 * Date:     2020/11/25 15:45
 * Description: 番茄钟控制的函数

 * 〈一句话功能简述〉<br>
 * 〈番茄钟控制的函数〉
 *

 * @create 2020/11/25
 * @since 1.0.0
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈番茄钟控制的函数〉
 * @since 1.0.0
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈番茄钟控制的函数〉
 * @since 1.0.0
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈番茄钟控制的函数〉
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
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/tomatoclock")
public class TomatoController {
    //服务层注册
    @Autowired
    private TodoService todoService;
    //  @Qualifier("tomatoClockService")

    //初始化实现层
    @Qualifier("tomatoClockImpl")
    @Autowired
    private TomatoClockService tomatoClockService;

    /**
     * @param tomatoClock
     * @Date
     * @return:int
     */
    //Post方法添加番茄钟
    @RequestMapping(value = "/addTomato", method = RequestMethod.POST)
    public int addTomatoClock(@RequestBody TomatoClock tomatoClock) {
        int tomatoId = tomatoClockService.getTomatoClockID() + 1;
        tomatoClock.setTomatoClockID(tomatoId);
        return tomatoClockService.addTomatoClock(tomatoClock);
    }

    /**
     * Delete方法 根据tomatoClockID删除对应的tomatoclock
     * @param tomatoClockID
     * @return ：int
     */
    @RequestMapping(value = "/deleteTomatoClockByTomatoClockId/{tomatoClockID}", method = RequestMethod.DELETE)
    public int deleteTomatoClockByTomatoClockId(@PathVariable("tomatoClockID") int tomatoClockID) {
        return tomatoClockService.deleteTomatoClockByTomatoClockId(tomatoClockID);
    }

    /**
     * Delete方法 根据userID删除对应的tomatoclock
     * @param userID
     * @return
     */
    @RequestMapping(value = "/deleteTomatoClockByuserID/{userID}", method = RequestMethod.DELETE)
    public int deleteTomatoClockByuserID(@PathVariable("userID") int userID) {
        return tomatoClockService.deleteTomatoClockByuserID(userID);
    }

    /**修改番茄钟的设置（初始化） PUT方法
     * @param tomatoClock
     * @return:int
     */
    @RequestMapping(value = "/updateTomatoClock", method = RequestMethod.PUT)
    public int updateTomatoClock(@RequestBody TomatoClock tomatoClock) {
        return tomatoClockService.updateTomatoClock(tomatoClock);
    }

    /**PATCH方法 设置番茄钟的状态
     * @param tomatoClock
     */
    @RequestMapping(value = "/setTomatoClockState",method = RequestMethod.PATCH)
    public int SetTomatoClockState(@RequestBody TomatoClock tomatoClock) {
        //    Todo todo = todoService.getTodoByTodoId(todoService.getMaxTodoId());
        return tomatoClockService.SetTomatoClockState(tomatoClock);
    }

    /**
     * PATCH 中止番茄钟
     * @param tomatoClock
     * @return
     */
    @RequestMapping(value = "/overTomatoClock", method = RequestMethod.PATCH)
    public int OverTomatoClock(@RequestBody TomatoClock tomatoClock) {
        return tomatoClockService.OverTomatoClock(tomatoClock);
    }

    /**
     * 根据tomatoClockID获取对应番茄钟  GET方法
     * @param tomatoClockID
     * @return
     */
    @RequestMapping(value = "/getTomatoClockById/{tomatoClockID}", method = RequestMethod.GET)
    public TomatoClock getTomatoClockById(@PathVariable("tomatoClockID") int tomatoClockID) {
     //   System.out.println(tomatoClockService.gettest(tomatoClockID).toString());
        TomatoClock t = tomatoClockService.getTomatoClockById(tomatoClockID);
        return t;
    }

    /**
     * 暂停番茄钟 PUT方法
     * @param tomatoClock
     * @return
     */
    @RequestMapping(value = "/sleepTomatoClock", method = RequestMethod.PUT)
    public int SleepTomatoClock(TomatoClock tomatoClock) {

        return tomatoClockService.SleepTomatoClock(tomatoClock);
    }

    /**
     * 生成工作日志
     * @param userID
     * @return
     */
    @RequestMapping(value = "/setSummary",method = RequestMethod.PATCH)
    public int setSummary(@Param("userID") int userID){
        return tomatoClockService.setSummary(userID);
};

}