package com.yjn.crowd.po;

import java.io.Serializable;
import lombok.Data;

/**
 * t_member_launch_info
 * @author 
 */
@Data
public class MemberLaunchInfoPO implements Serializable {
    private Integer id;

    /**
     * 会员 id
     */
    private Integer memberid;

    /**
     * 简单介绍
     */
    private String descriptionSimple;

    /**
     * 详细介绍
     */
    private String descriptionDetail;

    /**
     * 联系电话
     */
    private String phoneNum;

    /**
     * 客服电话
     */
    private String serviceNum;

    private static final long serialVersionUID = 1L;
}