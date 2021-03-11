package com.zjft.cloud.service;

import com.zjft.cloud.pojo.Course;
import com.zjft.cloud.service.impl.CourseServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/9 17:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {

    @Resource
    CourseServiceImpl courseService;

    @Test
    public void test01(){

        Course course = courseService.qryCourseById(1);
        System.out.println(course);
    }


}
