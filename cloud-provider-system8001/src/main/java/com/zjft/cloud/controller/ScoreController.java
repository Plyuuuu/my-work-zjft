package com.zjft.cloud.controller;

import com.zjft.cloud.pojo.CommonResult;
import com.zjft.cloud.service.impl.CourseServiceImpl;
import com.zjft.cloud.service.impl.ScoreServiceImpl;
import com.zjft.cloud.service.impl.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/11 11:19
 */
@Slf4j
@RestController
@RequestMapping(value = "/score")
public class ScoreController {

    @Resource
    private ScoreServiceImpl scoreService;

    @Resource
    private CourseController courseController;

    @Resource
    private StudentController studentController;
    // ====================================================== 1、增 ====================================================

    /**
     * 1、添加学生课程成绩
     *  【问题】
     *      1、要不要先判断是否有该学生与该课程，都有才添加？
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

        log.info("====================== 开始判断是否存在学生与课程 sId:[{}],cId:[{}] =========================",sId,cId);
        CommonResult commonResult1 = courseController.qryCourseById(cId);
        CommonResult commonResult2 = studentController.qryStudentById(sId);
        if ((commonResult1.getRetCode() == 200) && (commonResult2.getRetCode() == 200)){
            log.info("====================== 判断是否存在学生与课程结束 sId:[{}],cId:[{}] true=========================",sId,cId);
            // 都存在，开始添加
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
                    commonResult.setRetMsg("添加学生课程成绩失败，改成绩已存在");
                }
            }
        }else {
            log.info("====================== 判断是否存在学生与课程结束 sId:[{}],cId:[{}] false=========================",sId,cId);
            // 含有不存在的学号或课程号，不添加
            commonResult.setRetCode(444);
            commonResult.setRetMsg("添加学生课程成绩失败，学号或课程号不存在");
        }

        return commonResult;
    }

    // ====================================================== 2、删 ====================================================


    // ====================================================== 3、改 ====================================================

    /**
     * 1、修改学生课程成绩
     *  【注意】修改成绩是只修改成绩，学号和课程号是固定且保证存在的，有前端获取且不可修改
     * @param map
     * @return
     */
    @PutMapping(value = "/modScore")
    public CommonResult modScore(@RequestBody Map<String,Integer> map){
        CommonResult commonResult = new CommonResult();
        boolean res = false;

        Integer sId = map.get("sId");
        Integer cId = map.get("cId");
        Integer score = map.get("score");
        log.info("============= 获取前端数据: sId:[{}],cId[{}],score[{}] =============",sId,cId,score);
        try {
            log.info("====================== 开始修改学生课程成绩  sId:[{}],cId[{}],score[{}] =========================",sId,cId,score);
            res = scoreService.modScore(map);

        } catch (Exception e) {
            log.info("=============== 修改学生课程成绩出错 :[{}]===============",e.getMessage());
            e.printStackTrace();
        } finally {
            log.info("====================== 修改学生课程成绩结束  sId:[{}],cId[{}],score[{}] =========================",sId,cId,score);
            // 修改成功
            if (res){
                commonResult.setRetCode(200);
                commonResult.setRetMsg("修改成绩成功");
                commonResult.setData(res);
            // 修改失败
            }else {
                commonResult.setRetCode(444);
                commonResult.setRetMsg("修改成绩失败");
                commonResult.setData(res);
            }

        }


        return commonResult;
    }


    // ====================================================== 4、查 ====================================================


}
