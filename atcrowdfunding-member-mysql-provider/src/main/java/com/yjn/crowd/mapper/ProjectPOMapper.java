package com.yjn.crowd.mapper;


import com.yjn.crowd.po.ProjectPO;
import com.yjn.crowd.po.ProjectPOExample;
import com.yjn.crowd.vo.DetailProjectVO;
import com.yjn.crowd.vo.PortalProjectVO;
import com.yjn.crowd.vo.PortalTypeVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lenovo
 */
@Service
public interface ProjectPOMapper {
    int countByExample(ProjectPOExample example);

    int deleteByExample(ProjectPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPO record);

    int insertSelective(ProjectPO record);

    List<ProjectPO> selectByExample(ProjectPOExample example);

    ProjectPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByExample(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByPrimaryKeySelective(ProjectPO record);

    int updateByPrimaryKey(ProjectPO record);

    void insertTypeRelationship(@Param("typeIdList") List<Integer> typeIdList, @Param("projectId") Integer projectId);

    void insertTagRelationship(@Param("tagIdList") List<Integer> tagIdList, @Param("projectId") Integer projectId);

    List<PortalTypeVO> selectPortalTypeVOList();

    List<PortalProjectVO> selectPortalProjectVOList();

    DetailProjectVO selectDetailProjectVO(Integer projectId);

}