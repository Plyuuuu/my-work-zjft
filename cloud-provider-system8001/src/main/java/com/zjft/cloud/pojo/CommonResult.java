package com.zjft.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * 与前端交互的Json封装体
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/9 15:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    /**
     * 返回状态码
     */
    private Integer retCode;

    /**
     * 返回信息
     */
    private String retMsg;

    /**
     * 返回数据
     */
    private T       data;

    /**
     * 无数据构造方法
     * @param retCode
     * @param retMsg
     */
    public CommonResult(Integer retCode,String retMsg){
        this(retCode,retMsg,null);
    }

}
