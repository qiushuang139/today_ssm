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

import com.today.entity.TomatoClockStateRecord;
import com.today.service.TomatoClockStateRecordService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tomatoClcokStateRecord")
public class TomatoClockStateRecordController {
    @Autowired
    private TomatoClockStateRecordService tomatoClockStateRecordService;
//@RequestMapping("/setSummry")
//    public String setSummry(TomatoClockStateRecord tomatoClockStateRecord){
//return tomatoClockStateRecordService.getSummry();
//};
    
    //用post方法通过tomatoClockID获取对应番茄钟的使用记录
    @RequestMapping(value = "/getRecord/{tomatoClockID}", method = RequestMethod.GET)
    public List<TomatoClockStateRecord> getRecord(@PathVariable("tomatoClockID") int tomatoClockID) {
        List<TomatoClockStateRecord> tomatoClockStateRecords = tomatoClockStateRecordService.getRecord(tomatoClockID);

        return tomatoClockStateRecords;
    }

    ;

    //未完成 生成工作日志
    public int generateDiary(@PathVariable("userId") int userId) {
        return tomatoClockStateRecordService.generateDiary(userId);
    }

    ;
}
