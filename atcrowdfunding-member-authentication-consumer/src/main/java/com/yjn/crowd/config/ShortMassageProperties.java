package com.yjn.crowd.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: yjn
 * @Date: 2020/7/21 11:11
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "short.message")
public class ShortMassageProperties {
    private String templateID;
    private String appCode;
    private String messageList;
}
