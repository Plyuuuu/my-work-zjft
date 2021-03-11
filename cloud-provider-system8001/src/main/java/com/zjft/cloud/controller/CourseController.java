package com.zjft.cloud.controller;

import com.zjft.cloud.pojo.CommonResult;
import com.zjft.cloud.pojo.Course;
import com.zjft.cloud.service.impl.CourseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 *  https://www.cnblogs.com/libin6505/p/8315359.html
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/9 17:35
 */
@RestController
@Slf4j
@RequestMapping(value = "/course")
public class CourseController {

    @Resource
    private CourseServiceImpl courseService;


    // ====================================================== 1、增 ====================================================

    /**
     * 1、添加课程
     *      只指定 name
     * @param course
     * @return
     */
    @PostMapping(value = "/addCourse")
    public CommonResult addCourse(@RequestBody Course course){

        if (course.getName().isEmpty()){
            return new CommonResult(444,"添加失败,课程名为空",null);
        }

        log.info("======================开始添加课程信息=========================");
        int i = courseService.addCourse(course);
        log.info("======================添加课程信息结束=========================");
        // 添加成功
        if ( i > 0 ){
            return new CommonResult(200,"添加成功",i);
        }else {
            return new CommonResult(444,"添加失败",null);
        }

    }

    /**
     * 2、添加课程
     * @param map
     * @return
     */
    @PostMapping(value = "/addCourse2")
    public CommonResult addCourse2(@RequestBody Map map){

        log.info("======================开始添加课程信息=========================");
        CommonResult commonResult = new CommonResult();
        int res = 0;
        Integer id = (Integer) map.get("id");
        String name = (String) map.get("name");
        // 判断用户是否传入了 id
        if (id == null){
            // 没有传递 id,使用默认 id 策略
            return addCourse(new Course(null,name));
        }else {
            // 传入 id,先判断 id 是否合法
            if (id<=0){
                // id 不合法，禁止添加
                commonResult.setRetCode(444);
                commonResult.setRetMsg(" id 必须大于 0");
                return commonResult;
            }else {
                // 含有合法 id ，name，执行添加操作
                try{
                    res = courseService.addCourse2(map);

                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                    log.info("======================添加课程信息结束=========================");

                    // 添加成功
                    if (res>0){
                        commonResult.setRetCode(200);
                        commonResult.setRetMsg("添加成功");
                        commonResult.setData(res);

                        return commonResult;
                    }else {

                        commonResult.setRetCode(444);
                        commonResult.setRetMsg("添加失败");
                        commonResult.setData(res);
                        return commonResult;
                    }

                }


            }
        }


    }

    // ====================================================== 2、删 ====================================================

    @DeleteMapping(value = "/delCourseById")
    public CommonResult delCourseById(@RequestParam("id") Integer id){
        CommonResult commonResult = new CommonResult();
        log.info("======================开始删除课程信息 id:[{}]=========================",id);
        // 不符合的 id，提高效率
        if (id <= 0 ){
            commonResult.setRetCode(444);
            commonResult.setRetMsg("请输入正确的课程 id ");
            return commonResult;
        }else {
            boolean b = courseService.delCourseById(id);
            log.info("======================删除课程信息结束 id:[{}]=========================",id);
            if (b){
                commonResult.setRetCode(200);
                commonResult.setRetMsg("删除成功");
                commonResult.setData(b);
                return commonResult;
            }else {
                commonResult.setRetCode(444);
                commonResult.setRetMsg("删除失败");
                commonResult.setData(b);
                return commonResult;
            }
        }



    }
    @DeleteMapping(value = "/delCourseByName")
    public CommonResult delCourseByName(@RequestParam("name") String name){
        CommonResult commonResult = new CommonResult();
        log.info("======================开始删除课程信息 name:[{}]=========================",name);
        // 不符合的 name，提高效率
        if (StringUtils.isEmpty(name)){
            commonResult.setRetCode(444);
            commonResult.setRetMsg("请输入正确的课程 name ");
            return commonResult;
        }else {
            boolean b = courseService.delCourseByName(name);
            log.info("======================删除课程信息结束 name:[{}]=========================",name);
            if (b){
                commonResult.setRetCode(200);
                commonResult.setRetMsg("删除成功");
                commonResult.setData(b);
                return commonResult;
            }else {
                commonResult.setRetCode(444);
                commonResult.setRetMsg("删除失败");
                commonResult.setData(b);
                return commonResult;
            }
        }



    }




    // ====================================================== 3、改 ====================================================

    @PutMapping(value = "/modCourse")
    public CommonResult modCourse(@RequestBody Map map){

        CommonResult commonResult = new CommonResult();
        Integer id = (Integer) map.get("id");
        String name = (String) map.get("name");

        log.info("======================开始修改课程信息 id:[{}] name:[{}]=========================",id,name);
        // 过滤不合法 id
        if (id<=0){
            commonResult.setRetCode(444);
            commonResult.setRetMsg("不存在该id的课程 id:"+id);
            return commonResult;
        }else {
            boolean b = courseService.modCourse(map);
            log.info("======================修改课程信息结束 id:[{}] name:[{}]=========================",id,name);
            if (b){
                commonResult.setRetCode(200);
                commonResult.setRetMsg("修改成功");
                commonResult.setData(b);
                return commonResult;

            }else {
                commonResult.setRetCode(444);
                commonResult.setRetMsg("不存在该id的课程 id:"+id);
                commonResult.setData(b);
                return commonResult;
            }

        }


    }


    // ====================================================== 4、查 ====================================================

    /**
     * 查询所有课程信息
     * @return
     */
    @GetMapping(value = "/qryCourseAll")
    public CommonResult qryCourseAll(){

        CommonResult commonResult = new CommonResult();
        commonResult.setRetCode(200);

        log.info("======================开始查询所有课程信息=========================");
        List<Course> courses = courseService.qryCourseAll();
        if (courses.isEmpty()){
            commonResult.setRetMsg("查询成功,无课程信息");
        }else {
            commonResult.setRetMsg("查询成功");
        }
        commonResult.setData(courses);


        log.info("======================查询所有课程信息结束=========================");

        return commonResult;
    }


    @GetMapping(value = "/qryCourseById")
    public CommonResult qryCourseById(@RequestParam(value = "id") Integer id){

        log.info("======================通过id:[{}] 来查询课程信息=========================",id);

        CommonResult commonResult = new CommonResult();

        //  如果 id 没有被传入，就查询出所有课程信息
        if (id == null){

            return qryCourseAll();

            // 如果 id 传入，则查询数据库
        }else {

            Course course = courseService.qryCourseById(id);
            if (course!=null){
                commonResult.setRetCode(200);
                commonResult.setRetMsg("查询成功");
                commonResult.setData(course);
            }else {
                commonResult.setRetCode(444);
                commonResult.setRetMsg("查询失败，请输入正确的课程号");

            }

        }
        log.info("======================通过id:[{}] 查询课程信息结束=========================",id);
        return commonResult;
    }

    @GetMapping(value = "/qryCourseByName")
    public CommonResult qryCourseByName(@RequestParam(value = "name")String name){
        CommonResult commonResult = new CommonResult();
        log.info("======================通过name:[{}] 查询课程信息结束=========================",name);
        // 如果 name 没有被传入，则查询出所有课程信息
        if (StringUtils.isEmpty(name)){
            return qryCourseAll();
        }else {
            Course course = courseService.qryCourseByName(name);
            if (course!=null){
                commonResult.setRetCode(200);
                commonResult.setRetMsg("查询成功");
                commonResult.setData(course);
            }else {
                commonResult.setRetCode(444);
                commonResult.setRetMsg("查询失败，请输入正确的课程名");
            }
        }

        log.info("======================通过name:[{}] 查询课程信息结束=========================",name);
        return commonResult;
    }

}
