package com.yjn.crowd.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: yjn
 * @Date: 2020/7/24 10:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OSSProperties {
    private String endPoint;
    private String bucketName;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketDomain;
}
