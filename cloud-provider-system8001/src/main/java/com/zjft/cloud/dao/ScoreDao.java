package com.zjft.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/11 10:39
 */
@Mapper
public interface ScoreDao {

    // ====================================================== 1、增 ====================================================

    /**
     * 1、添加学生成绩
     * @param map
     * @return
     */
    boolean addScore(Map<String,Integer> map);

    // ====================================================== 2、删 ====================================================

    // ====================================================== 3、改 ====================================================

    /**
     * 1、修改学生成绩
     * @param map
     * @return
     */
    boolean modScore(Map<String,Integer> map);

    // ====================================================== 4、查 ====================================================




}
