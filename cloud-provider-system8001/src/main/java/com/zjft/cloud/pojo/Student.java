package com.zjft.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * 学生类
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/9 15:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    /**
     * 学号
     */
    private Integer id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生生日
     */
    private String birthday;

    /**
     * 学生性别
     */
    private String sex;

}
