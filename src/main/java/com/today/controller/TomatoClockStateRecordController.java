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
import org.springframework.web.bind.annotation.RequestMapping;

public class TomatoClockStateRecordController {
private TomatoClockStateRecordService tomatoClockStateRecordService;
@RequestMapping("/setSummry")
    public String setSummry(TomatoClockStateRecord tomatoClockStateRecord){
return tomatoClockStateRecordService.getSummry();




};

@RequestMapping("/getRecord/{userId}")
  public TomatoClockStateRecord getRecord(@Param("userId") int userId){
 return tomatoClockStateRecordService.getRecord(userId);
};
    @RequestMapping("/generateDiary/{userId}")
    public  int generateDiary(@Param("userId")int userId){
 return  tomatoClockStateRecordService.generateDiary(userId);
    };
}
