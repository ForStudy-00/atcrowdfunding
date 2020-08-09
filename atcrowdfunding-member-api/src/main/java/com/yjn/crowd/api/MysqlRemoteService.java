package com.yjn.crowd.api;

import com.yjn.crowd.po.MemberPo;
import com.yjn.crowd.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: yjn
 * @Date: 2020/7/19 18:32
 */
@FeignClient("yjn-crowd-mysql")
public interface MysqlRemoteService {

    @RequestMapping("/get/memberpo/by/login/acct/remote")
    ResultEntity<MemberPo> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct);

    @RequestMapping("/save/member/remote")
    ResultEntity<String> saveMember(@RequestBody MemberPo memberPo);
}
