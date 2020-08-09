package com.yjn.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: yjn
 * @Date: 2020/7/24 16:47
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class CrowdProjectConsumerMainClass {
    public static void main(String[] args) {
        SpringApplication.run(CrowdProjectConsumerMainClass.class, args);
    }
}
