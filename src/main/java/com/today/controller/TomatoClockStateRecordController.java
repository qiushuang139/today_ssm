/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TomatoClockStateRecordController
 * Author:   liyou
 * Date:     2020/12/2 11:20
 * Description: 番茄钟使用记录
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈番茄钟使用记录〉
 *
 * @author liyou
 * @create 2020/12/2
 * @author liyou
 * @create 2020/12/2
 * @since 1.0.0
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈番茄钟使用记录〉
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈番茄钟使用记录〉
 *
 * @author liyou
 * @create 2020/12/2
 * @since 1.0.0
 */
package com.today.controller;

import com.today.component.annotation.Authorization;
import com.today.entity.TomatoClockStateRecord;
import com.today.model.ResultModel;
import com.today.service.TomatoClockStateRecordService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tomatoclcokstaterecord")
@Transactional(rollbackFor = { Exception.class })
public class TomatoClockStateRecordController {
    @Autowired
    private TomatoClockStateRecordService tomatoClockStateRecordService;
//@RequestMapping("/setSummry")
//    public String setSummry(TomatoClockStateRecord tomatoClockStateRecord){
//return tomatoClockStateRecordService.getSummry();
//};
    
    //用post方法通过tomatoClockID获取对应番茄钟的使用记录
    @RequestMapping(value = "/{tomatoClockID}",method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getRecord(@PathVariable("tomatoClockID") int tomatoClockID,int page,int pageSize) {
        try {
            List<TomatoClockStateRecord> tomatoClockStateRecords =
                    tomatoClockStateRecordService.getRecord(tomatoClockID,page,pageSize);
            return new ResponseEntity(
                    new ResultModel(HttpStatus.OK,tomatoClockStateRecords),HttpStatus.OK
                    );
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(
                    new ResultModel(HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    ;

    //未完成 生成工作日志
//    public int generateDiary(@PathVariable("userId") int userId) {
//        return tomatoClockStateRecordService.generateDiary(userId);
//    }

    ;
}
