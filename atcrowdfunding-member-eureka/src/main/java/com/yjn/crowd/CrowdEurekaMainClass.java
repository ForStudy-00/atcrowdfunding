package com.yjn.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: yjn
 * @Date: 2020/7/19 9:11
 */
@EnableEurekaServer
@SpringBootApplication
public class CrowdEurekaMainClass {
    public static void main(String[] args) {
        SpringApplication.run(CrowdEurekaMainClass.class, args);
    }
}
