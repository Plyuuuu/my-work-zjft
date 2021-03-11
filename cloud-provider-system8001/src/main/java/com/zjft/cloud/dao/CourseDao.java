package com.zjft.cloud.dao;

import com.zjft.cloud.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/9 16:31
 */
@Mapper
public interface CourseDao {

    // ====================================================== 1、增 ====================================================

    /**
     * 1、添加course
     *  只包含 name
     * @param course
     * @return
     */
    public int addCourse(Course course);

    /**
     * 2、添加course
     *  包含 id、name
     * @param map
     * @return
     */
    public int addCourse2(Map<String,Object> map);

    // ====================================================== 2、删 ====================================================

    /**
     * 1、通过 id 删除课程
     * @param id
     * @return
     */
    public boolean delCourseById(@Param("id") Integer id);

    /**
     * 2、通过 name 删除课程
     * @param name
     * @return
     */
    public boolean delCourseByName(@Param("name") String name);

    // ====================================================== 3、改 ====================================================

    /**
     * 修改course
     * @param map
     * @return
     */
    public boolean modCourse(Map<String,Object> map);


    // ====================================================== 4、查 ====================================================

    /**
     * 1、通过id查询课程
     * @param id
     * @return
     */
    public Course qryCourseById(@Param("id") Integer id);

    /**
     * 2、通过课程名字查询
     *
     * @param name
     * @return
     */
    public Course qryCourseByName(@Param("name") String name);

    /**
     * 3、查询所有的课程信息
     * @return
     */
    public List<Course> qryCourseAll();

}
