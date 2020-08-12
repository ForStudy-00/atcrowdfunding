package com.yjn.crowd.mapper;


import com.yjn.crowd.po.MemberPo;
import com.yjn.crowd.po.MemberPoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface MemberPoMapper {
    int countByExample(MemberPoExample example);

    int deleteByExample(MemberPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberPo record);

    int insertSelective(MemberPo record);

    List<MemberPo> selectByExample(MemberPoExample example);

    MemberPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberPo record, @Param("example") MemberPoExample example);

    int updateByExample(@Param("record") MemberPo record, @Param("example") MemberPoExample example);

    int updateByPrimaryKeySelective(MemberPo record);

    int updateByPrimaryKey(MemberPo record);
}