package com.yjn.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: yjn
 * @Date: 2020/7/20 15:01
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class CrowdZuulMainClass {

    public static void main(String[] args) {
        SpringApplication.run(CrowdZuulMainClass.class, args);
    }
}
