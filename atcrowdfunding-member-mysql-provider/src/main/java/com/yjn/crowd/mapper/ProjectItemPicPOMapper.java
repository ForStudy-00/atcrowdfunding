package com.yjn.crowd.mapper;


import com.yjn.crowd.po.ProjectItemPicPO;
import com.yjn.crowd.po.ProjectItemPicPOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectItemPicPOMapper {
    int countByExample(ProjectItemPicPOExample example);

    int deleteByExample(ProjectItemPicPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectItemPicPO record);

    int insertSelective(ProjectItemPicPO record);

    List<ProjectItemPicPO> selectByExample(ProjectItemPicPOExample example);

    ProjectItemPicPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectItemPicPO record, @Param("example") ProjectItemPicPOExample example);

    int updateByExample(@Param("record") ProjectItemPicPO record, @Param("example") ProjectItemPicPOExample example);

    int updateByPrimaryKeySelective(ProjectItemPicPO record);

    int updateByPrimaryKey(ProjectItemPicPO record);

    void insertPathList(@Param("projectId") Integer projectId, @Param("detailPicturePathList") List<String> detailPicturePathList);
}