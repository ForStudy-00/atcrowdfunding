package com.yjn.crowd.service.api;

import com.yjn.crowd.vo.AddressVO;
import com.yjn.crowd.vo.OrderProjectVO;
import com.yjn.crowd.vo.OrderVO;

import java.util.List;

/**
 * @Author: yjn
 * @Date: 2020/8/13 14:42
 */
public interface OrderService {
    OrderProjectVO getOrderProjectVO(Integer projectId, Integer returnId);

    List<AddressVO> getAddressVOList(Integer memberId);

    void saveAddress(AddressVO addressVO);

    void saveOrder(OrderVO orderVO);
}
