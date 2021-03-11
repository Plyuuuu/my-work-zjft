package com.zjft.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/9 15:42
 */
@SpringBootApplication
@EnableEurekaClient
public class SystemMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(SystemMain8001.class,args);
    }
}
