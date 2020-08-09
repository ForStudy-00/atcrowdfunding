package com.yjn.crowd.service.impl;

import com.yjn.crowd.mapper.ProjectMapper;
import com.yjn.crowd.service.api.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: yjn
 * @Date: 2020/7/24 13:38
 */
@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {
    @Autowired(required = false)
    private ProjectMapper projectMapper;
}
