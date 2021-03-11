package com.zjft.cloud.controller;

import com.zjft.cloud.pojo.CommonResult;
import com.zjft.cloud.pojo.Student;
import com.zjft.cloud.service.StudentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/9 15:42
 */
@RestController
@Slf4j
@RequestMapping(value = "/student")
public class StudentController {

    @Resource
    private StudentService studentService;


    // ====================================================== 1、增 ====================================================

    @PostMapping(value = "/addStudent")
    public CommonResult addStudent(@RequestBody Map<String, Object> map){
        CommonResult commonResult = new CommonResult();

        int res = 0;

        Integer id = (Integer) map.get("id");
        String name = (String) map.get("name");
        String birthday = (String) map.get("birthday");
        String sex = (String) map.get("sex");

        log.info("=========获取前端的数据:id[{}],name[{}],birthday[{}],sex[{}]=========",id,name,birthday,sex);

        // 判断是否传入 id
        if (id != null){
            // 传入了id，判断 id 是否合法(>0)，
            if (id<1){
                // id不合法，给予添加
                commonResult.setRetCode(444);
                commonResult.setRetMsg("id 必须大于0，添加失败");
                return commonResult;
            }else {
                // id 合法，添加
                try{

                    log.info("======================开始添加学生信息 id:[{}]=========================",id);
                    res = studentService.addStudent(map);



                }catch (Exception e){
                    log.info("添加学生出错:[{}]",e.getMessage());
                }finally {
                    log.info("======================添加学生信息结束 id:[{}]=========================",id);

                    // 判断是否添加成功
                    if (res>0){
                        // 添加成功
                        commonResult.setRetCode(200);
                        commonResult.setRetMsg("添加成功");
                        commonResult.setData(res);
                        return commonResult;
                    }else {
                        // 添加失败
                        commonResult.setRetCode(444);
                        commonResult.setRetMsg("添加失败");
                        commonResult.setData(res);
                        return commonResult;
                    }

                }


            }

         // 没传入 id，使用默认 id
        }else {

            log.info("======================开始添加学生信息 id:[{}]=========================",id);
            res = studentService.addStudent(map);
            log.info("======================添加学生信息结束 id:[{}]=========================",id);

            // 判断是否添加成功
            if (res>0){
                // 添加成功
                commonResult.setRetCode(200);
                commonResult.setRetMsg("添加成功");
                commonResult.setData(res);
                return commonResult;
            }else {
                // 添加失败
                commonResult.setRetCode(444);
                commonResult.setRetMsg("添加失败");
                commonResult.setData(res);
                return commonResult;
            }

        }


    }


    // ====================================================== 2、删 ====================================================

    @DeleteMapping(value = "/delStudentById")
    public CommonResult delStudentById(@RequestParam("id") Integer id){

        CommonResult commonResult = new CommonResult();
        boolean res = false;

        // 过滤 id 提高效率
        if (id<1){

            commonResult.setRetCode(444);
            commonResult.setRetMsg("删除失败,id 必须>0");
            return commonResult;

        }else {
            try{
                log.info("======================开始删除学生信息 id:[{}]=========================",id);
                 res = studentService.delStudentById(id);

            }catch (Exception e){
                log.info("删除学生信息出错:[{}]",e.getMessage());
            }finally {
                log.info("======================删除学生信息结束 id:[{}]=========================",id);
                // 删除成功
                if (res){
                    commonResult.setRetCode(200);
                    commonResult.setRetMsg("删除成功");
                    commonResult.setData(res);
                // 删除失败
                }else {
                    commonResult.setRetCode(444);
                    commonResult.setRetMsg("删除失败");
                    commonResult.setData(res);
                }
            }
        }

        return commonResult;
    }


    // ====================================================== 3、改 ====================================================

    /**
     * 修改学生信息
     *  【注意】如果前端未传入某参数，而数据库中该参数不为 null，则会把数据库的该字段也会改为 null，需要前端控制某些字段不为空
     * @param map
     * @return
     */
    @PutMapping(value = "/modStudent")
    public CommonResult modStudent(@RequestBody Map<String,Object> map){
        CommonResult commonResult = new CommonResult();
        boolean res = false;

        Integer id = (Integer) map.get("id");
        String name = (String) map.get("name");
        String birthday = (String) map.get("birthday");
        String sex = (String) map.get("sex");

        log.info("=========获取前端的数据:id[{}],name[{}],birthday[{}],sex[{}]=========",id,name,birthday,sex);


        try{
            log.info("======================开始修改学生信息 id:[{}]=========================",id);
            res = studentService.modStudent(map);

        }catch (Exception e){
            log.info("修改学生信息出错:[{}]",e.getMessage());
        }finally {
            log.info("======================修改学生信息结束 id:[{}]=========================",id);
            // 修改成功
            if (res){
                commonResult.setRetCode(200);
                commonResult.setRetMsg("修改成功");
                commonResult.setData(res);
            }else {
                commonResult.setRetCode(444);
                commonResult.setRetMsg("修改失败");
                commonResult.setData(res);
            }
        }

        return commonResult;
    }



    // ====================================================== 4、查 ====================================================

    @GetMapping(value = "/qryStudentAll")
    public CommonResult qryStudentAll(){

        CommonResult commonResult = new CommonResult();
        log.info("======================开始查询所有学生信息=========================");
        List<Student> students = studentService.qryStudentAll();
        log.info("======================查询所有学生信息结束=========================");
        commonResult.setRetCode(200);
        commonResult.setRetMsg("查询成功");
        commonResult.setData(students);

        return commonResult;
    }
        

    @GetMapping(value = "/qryStudentById")
    public CommonResult qryStudentById(@RequestParam("id") Integer id){
        CommonResult commonResult = new CommonResult();
        Student res = null;

        log.info("======================开始查询学生信息 id:[{}]=========================",id);
        // 过滤不合法 id ，提高效率
        if (id <1){
            // 不合法 id，直接返回错误信息
            commonResult.setRetCode(444);
            commonResult.setRetMsg("查询失败，id 必须 > 0");
        }else {
            // 合法 id，查询数据库
            try{
                res = studentService.qryStudentById(id);
            }catch (Exception e){

                log.info("查询学生信息出错:[{}]",e.getMessage());
            }finally {
                log.info("======================查询学生信息结束 id:[{}]=========================",id);
                // 查询成功
                if (res != null){
                    commonResult.setRetCode(200);
                    commonResult.setRetMsg("查询学生信息成功");
                    commonResult.setData(res);
                // 查询出错
                }else {
                    commonResult.setRetCode(444);
                    commonResult.setRetMsg("查询学生信息失败");
                    commonResult.setData(res);
                }
            }

        }

        log.info("======================学生信息结束 id:[{}]=========================",id);

        return commonResult;
    }



    public CommonResult qryStudentByName(@RequestParam("name") String name){
        CommonResult commonResult = new CommonResult();

        return commonResult;
    }


    /**
     * 测试方法
     * @param id
     * @return
     */
    @GetMapping(value = "/get/{id}")
    public CommonResult getStudentByIdTest(@PathVariable Integer id){

        Student student = new Student(id,"Jack","1999-05-12","1");

        CommonResult<Student> commonResult = new CommonResult<>(200,"查询成功",student);

        return commonResult;
    }

}
