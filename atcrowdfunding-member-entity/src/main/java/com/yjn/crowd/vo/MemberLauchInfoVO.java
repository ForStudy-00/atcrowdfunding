package com.yjn.crowd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yjn
 * @Date: 2020/7/24 14:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberLauchInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;
    // 简单介绍
    private String descriptionSimple;
    // 详细介绍
    private String descriptionDetail;
    // 联系电话
    private String phoneNum;
    // 客服电话
    private String serviceNum;
}
