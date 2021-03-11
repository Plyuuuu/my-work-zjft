package com.zjft.cloud.controller;

import com.zjft.cloud.pojo.CommonResult;
import com.zjft.cloud.service.impl.ScoreServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/11 11:19
 */
@Slf4j
@RestController
public class ScoreController {

    @Resource
    private ScoreServiceImpl scoreService;

    // ====================================================== 1、增 ====================================================

    /**
     * 1、添加学生课程成绩
     *  【问题】
     *      1、要不要先判断是否有该学生与该课程，都有才添加。
     * @param map
     * @return
     */
    @PostMapping("/addScore")
    public CommonResult addScore(@RequestBody Map<String,Integer> map){
        CommonResult commonResult = new CommonResult();
        boolean res = false;

        Integer sId = map.get("sId");
        Integer cId = map.get("cId");
        Integer score = map.get("score");
        log.info("============= 获取前端数据: sId:[{}],cId[{}],score[{}] =============",sId,cId,score);

        log.info("====================== 开始添加成绩信息 sId:[{}],cId:[{}] =========================",sId,cId);

        try {
            res = scoreService.addScore(map);
        } catch (Exception e) {
            log.info("========添加学生课程成绩出错 :[{}] =======",e.getMessage());
        } finally {
            log.info("====================== 添加成绩信息结束 sId:[{}],cId:[{}] =========================",sId,cId);
            // 添加成功
            if (res){
                commonResult.setRetCode(200);
                commonResult.setRetMsg("添加学生课程成绩成功");

            // 添加失败
            }else {
                commonResult.setRetCode(444);
                commonResult.setRetMsg("添加学生课程成绩失败");

            }

        }


        return commonResult;
    }

    // ====================================================== 2、删 ====================================================


    // ====================================================== 3、改 ====================================================


    // ====================================================== 4、查 ====================================================


}
