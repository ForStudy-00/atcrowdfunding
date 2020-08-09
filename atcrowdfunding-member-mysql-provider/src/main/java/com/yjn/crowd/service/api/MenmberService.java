package com.yjn.crowd.service.api;

import com.yjn.crowd.po.MemberPo;

/**
 * @Author: yjn
 * @Date: 2020/7/19 20:30
 */
public interface MenmberService {
    MemberPo getMemberPOByLoginAcct(String loginacct);

    void saveMember(MemberPo memberPo);
}
