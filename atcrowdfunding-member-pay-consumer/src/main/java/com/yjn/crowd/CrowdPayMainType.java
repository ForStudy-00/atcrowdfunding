package com.yjn.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



/**
 * @author yjn
 */
@EnableFeignClients
@SpringBootApplication
public class CrowdPayMainType {
    public static void main(String[] args) {
        SpringApplication.run(CrowdPayMainType.class, args);
    }
}
