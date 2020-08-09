package com.yjn.crowd.handler;

import com.yjn.crowd.service.api.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yjn
 * @Date: 2020/7/24 13:37
 */
@RestController
public class ProjectProviderHandler {
    @Autowired
    private ProjectService projectService;
}
