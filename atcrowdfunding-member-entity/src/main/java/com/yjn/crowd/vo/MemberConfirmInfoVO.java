package com.yjn.crowd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yjn
 * @Date: 2020/7/24 14:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberConfirmInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;
    // 易付宝账号
    private String paynum;
    // 法人身份证号
    private String cardnum;
}
