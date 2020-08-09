package com.yjn.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: yjn
 * @Date: 2020/7/20 14:29
 */
@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
public class CrowdAuthConsumerMainClass {
    public static void main(String[] args) {
        SpringApplication.run(CrowdAuthConsumerMainClass.class, args);
    }
}
