package com.zjft.cloud.pojo;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *  日期类表示：https://zhidao.baidu.com/question/343791130.html
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/9 15:58
 */

public class DateTest {

    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd"); //这个格式你可以带上 时 ： 分： 秒 ，我这里只写了年月日

    @Test
    public void test01(){

        String sendTime = sf.format(new Date()); //获取当前时间，转成String 类型。塞到数据中我通常用String ， 只要格式正确，是数据库能认识的就可以了
        System.out.println(sendTime);
    }

}
