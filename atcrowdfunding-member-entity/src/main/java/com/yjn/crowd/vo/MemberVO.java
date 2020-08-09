package com.yjn.crowd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yjn
 * @Date: 2020/7/21 17:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private String loginacct;

    private String userpswd;

    private String username;

    private String email;

    private String phoneNum;

    private String code;
}
