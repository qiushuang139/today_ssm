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
import com.today.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/worklog")
@RestController
public class WorkLogController {
    @Autowired
    private LogService logService;

    /**
     *
     * @param workLog
     * @return
     */
    @RequestMapping(value = "add-log", method = RequestMethod.POST)
    @Authorization
    public ResponseEntity addLog(@RequestBody WorkLog workLog) {
        try {
            Date time = new Date();
            workLog.setDate(time);
            logService.addLog(workLog);

            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK, logService.getLogByDate(time)), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update-log", method = RequestMethod.PUT)
    @Authorization
    public ResponseEntity updateLog(@RequestBody WorkLog workLog) {
        try {
            logService.updateLog(workLog);
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK, logService.getLogByDate(workLog.getDate())), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @RequestMapping(value = "/delete-log-by-date", method = RequestMethod.DELETE)
    @Authorization
    public ResponseEntity deleteLogByDate(String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            logService.deleteLogByDate(formatter.parse(date));
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
    public ResponseEntity getLogByDate( String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            logService.deleteLogByDate(formatter.parse(date));
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK, logService.getLogByDate(formatter.parse(date))), HttpStatus.OK)
                    ;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
