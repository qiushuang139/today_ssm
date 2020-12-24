/**
 * FileName: TomatoController
 * Author:   liyou
 * Date:     2020/11/25 15:45
 * Description: 番茄钟控制的函数
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈番茄钟控制的函数〉
 *
 * @create 2020/11/25
 * @author liyou
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

import com.today.component.annotation.Authorization;
import com.today.entity.TomatoClock;
import com.today.model.ResultModel;
import com.today.service.TodoService;
import com.today.service.TomatoClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tomatoes")
public class TomatoController {
    //服务层注册
    @Autowired
    private TodoService todoService;
    //  @Qualifier("tomatoClockService")



    //初始化实现层
    @Qualifier("tomatoClockImpl")
    @Autowired
    private TomatoClockService tomatoClockService;

    @RequestMapping(value = "/get-tomato-by-userid/{userId} ",method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getTomatoClockByUserId(@PathVariable("userId") int userId, int page,int pageSize){
        try{
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,tomatoClockService.getTomatoClockByUserId(userId,page,pageSize)),HttpStatus.OK
            );
        }catch (Exception ex){
            ex.printStackTrace();
            return  new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }



    /**
     * @param tomatoClock
     * @Date
     * @return:int
     */
    //Post方法添加番茄钟
    @RequestMapping(method = RequestMethod.POST)
    @Authorization
    public ResponseEntity addTomatoClock(@RequestBody TomatoClock tomatoClock) {
        try {
            int tomatoId = tomatoClockService.getTomatoClockID() + 1;
            tomatoClock.setTomatoClockId(tomatoId);
            tomatoClockService.addTomatoClock(tomatoClock);
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK, tomatoClockService.getTomatoClockById(tomatoId)), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }


        // return tomatoClockService.addTomatoClock(tomatoClock);
    }

    /**
     * Delete方法 根据tomatoClockID删除对应的tomatoclock
     * @param tomatoClockId
     * @return ：int
     */
    @RequestMapping(value = "/delete-tomato-by-tomatoclockid/{tomatoClockId}", method = RequestMethod.DELETE)
    @Authorization
    public ResponseEntity deleteTomatoClockByTomatoClockId(@PathVariable("tomatoClockId") int tomatoClockId) {
        try {
            if (tomatoClockService.deleteTomatoClockByTomatoClockId(tomatoClockId) >= 1) {
                return new ResponseEntity(new ResultModel(HttpStatus.NO_CONTENT), HttpStatus.NO_CONTENT);

            }
            return new ResponseEntity(new ResultModel(HttpStatus.NOT_FOUND, tomatoClockId), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);

            //return tomatoClockService.deleteTomatoClockByTomatoClockId(tomatoClockId);
        }
    }

    /**
     * Delete方法 根据userID删除对应的tomatoclock
     * @param userID
     * @return
     */
    @RequestMapping(value = "/delete-tomato-by-userid/{userID}", method = RequestMethod.DELETE)
    @Authorization
    public ResponseEntity deleteTomatoClockByUserID(@PathVariable("userID") int userID) {
        try {
            if (tomatoClockService.deleteTomatoClockByUserID(userID) >= 1) {
                return new ResponseEntity(new ResultModel(HttpStatus.NO_CONTENT), HttpStatus.NO_CONTENT);

            }
            return new ResponseEntity(new ResultModel(HttpStatus.NOT_FOUND, userID), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }


        // return tomatoClockService.deleteTomatoClockByuserID(userID);
    }

    /**修改番茄钟的设置（初始化） PUT方法
     * @param tomatoClock
     * @return:int
     */
    @RequestMapping(method = RequestMethod.PUT)
    @Authorization
    public ResponseEntity updateTomatoClock(@RequestBody TomatoClock tomatoClock) {
        try {
            tomatoClockService.updateTomatoClock(tomatoClock);
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK, tomatoClockService.getTomatoClockById(tomatoClock.getTomatoClockId())), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);


        }
        //return tomatoClockService.updateTomatoClock(tomatoClock);
    }

    /**PATCH方法 设置番茄钟的状态
     * @param tomatoClockID
     */
    @RequestMapping(value = "/set-tomato-state/{tomatoClockId}", method = RequestMethod.PATCH)
    @Authorization
    public ResponseEntity setTomatoClockState(@PathVariable("tomatoClockId")int tomatoClockID, int type) {
        //    Todo todo = todoService.getTodoByTodoId(todoService.getMaxTodoId());
        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK, tomatoClockService.setTomatoClockState(tomatoClockID,type)), HttpStatus.OK);

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);

        }

        // return tomatoClockService.SetTomatoClockState(tomatoClock);
    }

    /**
     * PATCH 中止番茄钟
     * @param tomatoClock
     * @return
     */
    @RequestMapping(value = "/over-tomato/{tomatoId}", method = RequestMethod.PATCH)
    @Authorization
    public ResponseEntity overTomatoClock(@PathVariable("tomatoId")int tomatoId) {
        try {
            return new ResponseEntity(
                    new ResultModel(
                            HttpStatus.OK, tomatoClockService.overTomatoClock(tomatoId)), HttpStatus.OK
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        //  return tomatoClockService.OverTomatoClock(tomatoClock);
    }

    /**
     * 根据tomatoClockID获取对应番茄钟  GET方法
     * @param tomatoClockID
     * @return
     */
    @RequestMapping(value = "/{tomatoClockId}", method = RequestMethod.GET)
    public ResponseEntity getTomatoClockById(@PathVariable("tomatoClockId") int tomatoClockID) {
        //   System.out.println(tomatoClockService.gettest(tomatoClockId).toString());
        //   TomatoClock t = tomatoClockService.getTomatoClockById(tomatoClockId);
        // return t;

        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK, tomatoClockService.getTomatoClockById(tomatoClockID)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 暂停番茄钟 PUT方法
     * @param tomatoClock
     * @return
     */
    @RequestMapping(value = "/sleep-tomato/{tomatoId}", method = RequestMethod.PUT)
    @Authorization
    public ResponseEntity sleepTomatoClock(@PathVariable("tomatoId")int tomatoId) {
        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK, tomatoClockService.sleepTomatoClock(tomatoId)), HttpStatus.OK
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // return tomatoClockService.SleepTomatoClock(tomatoClock);
    }

    /**
     * 生成工作总结  抛弃
     * @param
     * @return
     */
//    @RequestMapping(value = "/set-summary", method = RequestMethod.PATCH)
//    @Authorization
//    public ResponseEntity setSummary(@CurrentUser User user,String summary) {
//        try {
//            return new ResponseEntity(
//                    new ResultModel(
//                            HttpStatus.OK, tomatoClockService.setSummary(user.getUserId(),summary)), HttpStatus.OK);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return new ResponseEntity(
//                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
//        } //   return tomatoClockService.setSummary(userID);
//    }

}