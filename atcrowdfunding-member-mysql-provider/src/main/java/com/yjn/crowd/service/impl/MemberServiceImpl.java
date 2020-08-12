package com.yjn.crowd.service.impl;

import com.yjn.crowd.mapper.MemberMapper;
import com.yjn.crowd.po.MemberPo;
import com.yjn.crowd.po.MemberPoExample;
import com.yjn.crowd.service.api.MenmberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: yjn
 * @Date: 2020/7/19 18:58
 */
@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MenmberService {

    @Autowired(required = false)
    private MemberMapper memberMapper;

    @Override
    public MemberPo getMemberPOByLoginAcct(String loginacct) {

        MemberPoExample example=new MemberPoExample();
        MemberPoExample.Criteria criteria = example.createCriteria();
        criteria.andLoginacctEqualTo(loginacct);
        List<MemberPo> members = memberMapper.selectByExample(example);
        if (members.size()==0){
            return null;
        }
        return members.get(0);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    @Override
    public void saveMember(MemberPo memberPo) {
        memberMapper.insertSelective(memberPo);
    }
}
