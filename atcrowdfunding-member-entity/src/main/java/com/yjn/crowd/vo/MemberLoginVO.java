package com.yjn.crowd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yjn
 * @Date: 2020/7/21 20:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class  MemberLoginVO implements Serializable {
    private Integer id;

    private String username;

    private String email;
}
