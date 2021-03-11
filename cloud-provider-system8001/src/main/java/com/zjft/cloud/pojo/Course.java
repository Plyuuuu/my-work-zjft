package com.zjft.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/9 16:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    /**
     * 课程编号
     */
    private Integer id;

    /**
     * 课程名
     */
    private String name;

}
