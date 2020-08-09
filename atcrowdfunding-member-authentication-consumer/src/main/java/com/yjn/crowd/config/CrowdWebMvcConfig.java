package com.yjn.crowd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: yjn
 * @Date: 2020/7/21 10:04
 */
@Configuration
public class CrowdWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/auth/member/to/reg/page").setViewName("member-reg");
        registry.addViewController("/auth/member/to/login/page").setViewName("member-login");
        registry.addViewController("/auth/member/to/center/page").setViewName("member-center");
        registry.addViewController("/member/my/crowd").setViewName("member-crowd");
//        registry.addViewController("/agree/protocol/page").setViewName("project-agree");
//        registry.addViewController("/launch/project/page").setViewName("project-launch");
    }
}
