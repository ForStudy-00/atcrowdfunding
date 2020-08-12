package com.yjn.crowd.api;

import com.yjn.crowd.po.MemberPo;
import com.yjn.crowd.util.ResultEntity;
import com.yjn.crowd.vo.DetailProjectVO;
import com.yjn.crowd.vo.PortalTypeVO;
import com.yjn.crowd.vo.ProjectVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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


    @RequestMapping("/save/project/vo/remote")
    ResultEntity<String> saveProjectVORemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId);

    @RequestMapping("/get/project/detail/remote/{projectId}")
    public ResultEntity<DetailProjectVO> getDetailProjectVORemote(@PathVariable("projectId") Integer projectId);

    @RequestMapping("/get/portal/type/project/data/remote")
    ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote();
}
