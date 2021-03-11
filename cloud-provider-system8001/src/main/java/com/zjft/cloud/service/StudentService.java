package com.zjft.cloud.service;

import com.zjft.cloud.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/10 15:50
 */
public interface StudentService {


    // ====================================================== 1、增 ====================================================

    /**
     * 添加学生
     * @param map
     * @return
     */
    int addStudent(Map<String,Object> map);


    // ====================================================== 2、删 ====================================================

    /**
     * 1、通过 id 删除学生
     *
     * @param id
     * @return
     */
    boolean delStudentById(@Param("id") int id);


    // ====================================================== 3、改 ====================================================

    /**
     * 修改学生信息
     *
     * @param map
     * @return
     */
    boolean modStudent(Map<String,Object> map);


    // ====================================================== 4、查 ====================================================

    /**
     * 1、查询所有学生信息
     * @return
     */
    List<Student> qryStudentAll();

    /**
     * 2、通过学号查询学生
     * @param id
     * @return
     */
    Student qryStudentById(@Param("id") Integer id);


    /**
     * 3、通过学生姓名查询
     *  【注意】学生可能存在重名，所以返回学生集合
     * @param name
     * @return
     */
    List<Student> qryStudentByName(@Param("name") String name);

    /**
     * 4、通过学生姓氏查询
     *  【注意】学生可能存在重姓氏，所以返回学生集合
     * @param lastName
     * @return
     */
    List<Student> qryStudentByLastName(@Param("lastName") String lastName);

    /**
     * 5、通过学生性别查询
     * @param sex
     * @return
     */
    List<Student> qryStudentBySex(@Param("sex") String sex);

}
