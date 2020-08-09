package com.yjn.crowd.po;

import java.io.Serializable;
import lombok.Data;

/**
 * t_member_confirm_info
 * @author 
 */
@Data
public class MemberConfirmInfoPO implements Serializable {
    private Integer id;

    /**
     * 会员 id
     */
    private Integer memberid;

    /**
     * 易付宝企业账号
     */
    private String paynum;

    /**
     * 法人身份证号
     */
    private String cardnum;

    private static final long serialVersionUID = 1L;
}