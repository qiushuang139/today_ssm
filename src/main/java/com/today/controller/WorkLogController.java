/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: WorkLogController
 * Author:   liyou
 * Date:     2020/12/17 11:33
 * Description: 工作日志控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈工作日志控制器〉
 *
 * @author liyou
 * @create 2020/12/17
 * @author liyou
 * @create 2020/12/17
 * @since 1.0.0
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈工作日志控制器〉
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈工作日志控制器〉
 *
 * @author liyou
 * @create 2020/12/17
 * @since 1.0.0
 */
package com.today.controller;

import com.today.component.annotation.Authorization;
import com.today.entity.WorkLog;
import com.today.model.ResultModel;
import com.today.service.WorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/worklogs")
@RestController
@Transactional(rollbackFor = { Exception.class })
public class WorkLogController {
    @Autowired
    private WorkLogService workLogService;

    /**
     *
     * @param workLog
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @Authorization
    public ResponseEntity addWorkLog(@RequestBody WorkLog workLog) {
        try {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date time = new Date();
            workLog.setDate(time);
            if(workLogService.getWorkLogByDate(workLog.getUserId(),formatter.format(time))!=null){
                return new ResponseEntity(new ResultModel(HttpStatus.OK),HttpStatus.OK);
            }
            workLogService.addWorkLog(workLog);
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK, workLogService.getWorkLogByDate(workLog.getUserId(),formatter.format(time))),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    @Authorization
    public ResponseEntity updateWorkLog(@RequestBody WorkLog workLog) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date=formatter.format(workLog.getDate());
            workLogService.updateWorkLog(workLog);
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK, workLogService.getWorkLogByDate(workLog.getUserId(),date)), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Authorization
    public ResponseEntity deleteWorkLogByDate(int userId,String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            workLogService.deleteWorkLogByDate(userId,formatter.parse(date));
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK), HttpStatus.OK
            );
        } catch (Exception ex
        ) {
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/get-log-by-date", method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getLogByDate(int userId,String date) {
        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK, workLogService.getWorkLogByDate(userId,date)), HttpStatus.OK)
                    ;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getWorkLogByUserID(int userId,int page,int pageSize){
        try {
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,workLogService.getWorkLogByUserID(userId,page,pageSize)),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
