package com.zjft.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/9 16:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {

    /**
     * 学生id
     */
    private Integer sId;

    /**
     * 课程id
     */
    private Integer cId;

    /**
     * 分数
     */
    private Integer score;

}
