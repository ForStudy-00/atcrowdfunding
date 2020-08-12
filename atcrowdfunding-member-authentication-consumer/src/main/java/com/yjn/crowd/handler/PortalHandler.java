package com.yjn.crowd.handler;

import com.yjn.crowd.api.MysqlRemoteService;
import com.yjn.crowd.constant.CrowdConstant;
import com.yjn.crowd.util.ResultEntity;
import com.yjn.crowd.vo.PortalTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: yjn
 * @Date: 2020/7/20 14:37
 */
@Controller
public class PortalHandler {

    @Autowired
    private MysqlRemoteService mysqlRemoteService;

    @RequestMapping("/")
    public String showPortalPage(Model model){
        //调用MySqlRemoteService提供的方法查询要显示的数据
        ResultEntity<List<PortalTypeVO>> resultEntity = mysqlRemoteService.getPortalTypeProjectDataRemote();
        //检查查询结果
        String result= resultEntity.getOperationResult();
        if (ResultEntity.SUCCESS.equals(result)){
            //获取查询结果的数据
            List<PortalTypeVO> list = resultEntity.getQueryData();
            //存入模型
            model.addAttribute(CrowdConstant.ATTR_NAME_PORTAL_DATA, list);
        }
        return "portal";
    }
}
