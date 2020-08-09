package com.yjn.crowd.po;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * t_member
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberPo implements Serializable {
    private Integer id;

    private String loginacct;

    private String userpswd;

    private String username;

    private String email;

    /**
     * 实名认证状态,0-未实名认证，1-实名认证申请中，2-已实名认证
     */
    private Integer authstatus;

    /**
     * 0-个人，1-企业
     */
    private Integer usertype;

    private String realname;

    private String cardnum;

    /**
     * 0-企业，1-个体，2-个人，3-政府
     */
    private Integer accttype;

    private static final long serialVersionUID = 1L;
}