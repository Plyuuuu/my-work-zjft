package com.zjft.cloud.dao;

import com.zjft.cloud.pojo.Course;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/9 17:07
 */
public class CourseDaoTest {


    @Resource
    private CourseDao courseDao;

    @Test
    public void test01(){
        System.out.println(courseDao);
        Course course = courseDao.qryCourseById(1);
        System.out.println(course);

    }

}
