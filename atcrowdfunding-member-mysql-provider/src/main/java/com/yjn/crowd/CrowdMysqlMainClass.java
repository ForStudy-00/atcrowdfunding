package com.yjn.crowd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: yjn
 * @Date: 2020/7/19 10:39
 */
@MapperScan("com.yjn.crowd.mapper")
@SpringBootApplication
public class CrowdMysqlMainClass {
    public static void main(String[] args) {
        SpringApplication.run(CrowdMysqlMainClass.class, args);
    }
}
