package com.yjn.crowd.handler;

import com.yjn.crowd.api.MysqlRemoteService;
import com.yjn.crowd.constant.CrowdConstant;
import com.yjn.crowd.util.ResultEntity;
import com.yjn.crowd.vo.AddressVO;
import com.yjn.crowd.vo.MemberLoginVO;
import com.yjn.crowd.vo.OrderProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: yjn
 * @Date: 2020/8/13 13:14
 */
@Controller
public class OrderHandler {
    @Autowired
    private MysqlRemoteService mysqlRemoteService;

    @RequestMapping("/save/address")
    public String saveAdress(AddressVO addressVO, HttpSession session) {
        ResultEntity<String> resultEntity = mysqlRemoteService.saveAddressRemote(addressVO);
        OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");
        Integer returnCount = orderProjectVO.getReturnCount();
        return "redirect:http://localhost:80/order/confirm/order/" + returnCount;
    }

    @RequestMapping("/confirm/order/{returnCount}")
    public String showConfirmOrderInfo(
            @PathVariable("returnCount") Integer returnCount,
            HttpSession session) {
        // 1.把接收到的回报数量合并到 Session 域
        OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");
        orderProjectVO.setReturnCount(returnCount);
        session.setAttribute("orderProjectVO", orderProjectVO);
        // 2.获取当前已登录用户的 id
        MemberLoginVO memberLoginVO = (MemberLoginVO) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
        Integer memberId = memberLoginVO.getId();
        // 3.查询目前的收货地址数据
        ResultEntity<List<AddressVO>> resultEntity = mysqlRemoteService.getAddressVORemote(memberId);
        if (ResultEntity.SUCCESS.equals(resultEntity.getOperationResult())) {
            List<AddressVO> list = resultEntity.getQueryData();
            session.setAttribute("addressVOList", list);
        }
        return "confirm_order";
    }

    @RequestMapping("/confirm/return/info/{projectId}/{returnId}")
    public String showReturnConfirmInfo(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("returnId") Integer returnId,
            HttpSession session) {
        System.out.println("wozhixingle");
        ResultEntity<OrderProjectVO> resultEntity =
                mysqlRemoteService.getOrderProjectVORemote(projectId, returnId);
        if (ResultEntity.SUCCESS.equals(resultEntity.getOperationResult())) {
            OrderProjectVO orderProjectVO = resultEntity.getQueryData();
            // 为了能够在后续操作中保持 orderProjectVO 数据，存入 Session 域
            session.setAttribute("orderProjectVO", orderProjectVO);
        }
        return "confirm_return";
    }
}
