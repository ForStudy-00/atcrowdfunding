package com.yjn.crowd.handler;

import com.yjn.crowd.constant.CrowdConstant;
import com.yjn.crowd.po.MemberPo;
import com.yjn.crowd.service.api.MenmberService;
import com.yjn.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yjn
 * @Date: 2020/7/19 18:53
 */
@RestController
public class MemberProviderHandler {

    @Autowired
    private MenmberService menmberService;

    @RequestMapping("/save/member/remote")
    public ResultEntity<String> saveMember(@RequestBody MemberPo memberPo){

        try {
            menmberService.saveMember(memberPo);
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException){
                return ResultEntity.failed(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
            }else {
                return ResultEntity.failed(e.getMessage());
            }
        }
    }

    @RequestMapping("/get/memberpo/by/login/acct/remote")
    public ResultEntity<MemberPo> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct){
        try {
            MemberPo member= menmberService.getMemberPOByLoginAcct(loginacct);
            return ResultEntity.successWithData(member);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    };

}
