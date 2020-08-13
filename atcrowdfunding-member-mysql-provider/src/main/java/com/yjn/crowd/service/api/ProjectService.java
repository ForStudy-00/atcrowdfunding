package com.yjn.crowd.service.api;

import com.yjn.crowd.vo.DetailProjectVO;
import com.yjn.crowd.vo.PortalTypeVO;
import com.yjn.crowd.vo.ProjectVO;

import java.util.List;

/**
 * @Author: yjn
 * @Date: 2020/7/24 13:38
 */
public interface ProjectService {
    /**
     * 保存项目信息
     * @param projectVO
     * @param memberId
     */
    void saveProject(ProjectVO projectVO, Integer memberId);
    List<PortalTypeVO> getPortalTypeVO();
    DetailProjectVO getDetailProjectVO(Integer projectId);
}
