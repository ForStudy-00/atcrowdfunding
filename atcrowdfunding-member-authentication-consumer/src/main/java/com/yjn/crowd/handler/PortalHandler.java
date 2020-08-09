package com.yjn.crowd.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: yjn
 * @Date: 2020/7/20 14:37
 */
@Controller
public class PortalHandler {

    @RequestMapping("/")
    public String showPortalPage(){
        return "portal";
    }
}
