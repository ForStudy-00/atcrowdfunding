package com.yjn.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: yjn
 * @Date: 2020/8/13 11:48
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class CrowdOrderConsumerMainClass {
    public static void main(String[] args) {
        SpringApplication.run(CrowdOrderConsumerMainClass.class, args);
    }

}
