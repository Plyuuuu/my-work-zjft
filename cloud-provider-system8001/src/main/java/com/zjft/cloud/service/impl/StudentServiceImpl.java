package com.zjft.cloud.service.impl;

import com.zjft.cloud.dao.StudentDao;
import com.zjft.cloud.pojo.Student;
import com.zjft.cloud.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/10 15:51
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public int addStudent(Map<String, Object> map) {
        return studentDao.addStudent(map);
    }

    @Override
    public boolean delStudentById(int id) {
        return studentDao.delStudentById(id);
    }

    @Override
    public boolean modStudent(Map<String, Object> map) {
        return studentDao.modStudent(map);
    }

    @Override
    public List<Student> qryStudentAll() {
        return studentDao.qryStudentAll();
    }

    @Override
    public Student qryStudentById(Integer id) {
        return studentDao.qryStudentById(id);
    }

    @Override
    public List<Student> qryStudentByName(String name) {
        return studentDao.qryStudentByName(name);
    }

    @Override
    public List<Student> qryStudentByLastName(String lastName) {
        return studentDao.qryStudentByLastName(lastName);
    }

    @Override
    public List<Student> qryStudentBySex(String sex) {
        return studentDao.qryStudentBySex(sex);
    }


}
