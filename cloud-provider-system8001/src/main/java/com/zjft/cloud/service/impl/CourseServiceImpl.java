package com.zjft.cloud.service.impl;

import com.zjft.cloud.dao.CourseDao;
import com.zjft.cloud.pojo.Course;
import com.zjft.cloud.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/9 17:15
 */
@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseDao courseDao;


    @Override
    public int addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    @Override
    public int addCourse2(Map<String, Object> map) {
        return courseDao.addCourse2(map);
    }

    @Override
    public boolean delCourseById(Integer id) {
        return courseDao.delCourseById(id);
    }

    @Override
    public boolean delCourseByName(String name) {
        return courseDao.delCourseByName(name);
    }

    @Override
    public boolean modCourse(Map<String, Object> map) {
        return courseDao.modCourse(map);
    }

    @Override
    public Course qryCourseById(Integer id) {
        return courseDao.qryCourseById(id);
    }

    @Override
    public Course qryCourseByName(String name) {
        return courseDao.qryCourseByName(name);
    }

    @Override
    public List<Course> qryCourseAll() {
        return courseDao.qryCourseAll();
    }


}
