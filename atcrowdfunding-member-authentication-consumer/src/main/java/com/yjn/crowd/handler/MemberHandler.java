package com.yjn.crowd.handler;

import com.yjn.crowd.api.MysqlRemoteService;
import com.yjn.crowd.api.RedisRemoteService;
import com.yjn.crowd.constant.CrowdConstant;
import com.yjn.crowd.po.MemberPo;
import com.yjn.crowd.util.CrowdUtil;
import com.yjn.crowd.util.ResultEntity;
import com.yjn.crowd.vo.MemberLoginVO;
import com.yjn.crowd.vo.MemberVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yjn
 * @Date: 2020/7/21 11:04
 */
@Controller
public class MemberHandler {

    @Autowired
    private RedisRemoteService redisRemoteService;

    @Autowired
    private MysqlRemoteService mysqlRemoteService;

    @RequestMapping("/auth/member/do/login")
    public String login(@RequestParam("loginacct") String loginacct, @RequestParam("userpswd") String userpswd, ModelMap modelMap, HttpSession session){
        ResultEntity<MemberPo> resultEntity = mysqlRemoteService.getMemberPOByLoginAcctRemote(loginacct);
        if (ResultEntity.FAILED.equals(resultEntity.getOperationResult())){
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, resultEntity.getOperationMessage());
            return "member-login";
        }
        MemberPo memberPo = resultEntity.getQueryData();
        if (memberPo==null){
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_LOGIN_FAILED);
            return "member-login";
        }

        //从数据库查询密码
        String databaseCode = memberPo.getUserpswd();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean matchesResult =  passwordEncoder.matches(userpswd, databaseCode);
        System.out.println("密码是否匹配"+matchesResult);
        if (!matchesResult){
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_LOGIN_FAILED);
            return "member-login";
        }
        MemberLoginVO memberLoginVO=new MemberLoginVO(memberPo.getId(), memberPo.getLoginacct(), memberPo.getEmail());
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER,memberLoginVO);
        return "redirect:http://localhost:80/auth/member/to/center/page";
    }

    @RequestMapping("/auth/do/member/register")
    public String register(MemberVO memberVO, ModelMap modelMap){
        //获取用户输入的手机号
        String phoneNum = memberVO.getPhoneNum();
        //拼接Redis里存储验证码的key
        String key=CrowdConstant.REDIS_CODE_PREFIX+phoneNum;
        //根据key从Redis里查询验证码
        ResultEntity<String> resultEntity = redisRemoteService.getRedisStringValueByKeyRemote(key);
        //检查查询操作是否有效
        String result=resultEntity.getOperationResult();
        if (ResultEntity.FAILED.equals(result)){
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, resultEntity.getOperationMessage());
            return "member-reg";
        }
        if (ResultEntity.SUCCESS.equals(result)){
            String redisCode=resultEntity.getQueryData();
            if (redisCode==null){
                modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_NOT_EXISTS);
                return "member-reg";
            }
            if (redisCode!=null){
                String formCode=memberVO.getCode();
                if (!Objects.equals(redisCode, formCode)){
                  modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_INVALID);
                }
                redisRemoteService.removeRedisKeyRemote(key);
                //密码加密
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String encode = passwordEncoder.encode(memberVO.getUserpswd());
                memberVO.setUserpswd(encode);
                //执行保存
                MemberPo memberPo=new MemberPo();
                BeanUtils.copyProperties(memberVO, memberPo);
                ResultEntity<String> saveMemberResultEntity = mysqlRemoteService.saveMember(memberPo);
                if (ResultEntity.FAILED.equals(saveMemberResultEntity.getQueryData())){
                    modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, saveMemberResultEntity.getOperationMessage());
                    return "member-reg";
                }
            }
        }
        //避免刷新浏览器造成重新注册的现象
        return "redirect:/auth/member/to/login/page";
    }

    @ResponseBody
    @RequestMapping("/auth/member/send/short/message")
    public ResultEntity<String> sendMessage(@RequestParam("phoneNum") String phoneNum,@RequestParam("code") String code ){
        ArrayList<String> message = new ArrayList<>();
        message.add(code);
        message.add("15");
        ResultEntity<String> resultEntity = CrowdUtil.sendMessage(phoneNum,  message);
        if (ResultEntity.SUCCESS.equals(resultEntity.getOperationResult())){
            String key= CrowdConstant.REDIS_CODE_PREFIX+phoneNum;
            ResultEntity<String> resultCodeEntity=redisRemoteService.setRedisKeyValueRemoteWithTimeout(key,code,15, TimeUnit.MINUTES);
            if (ResultEntity.SUCCESS.equals(resultCodeEntity.getOperationResult())){
                return ResultEntity.successWithoutData();
            }else {
                return resultCodeEntity;
            }
        }else {
            return resultEntity;
        }
    }

    @RequestMapping("/auth/member/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
