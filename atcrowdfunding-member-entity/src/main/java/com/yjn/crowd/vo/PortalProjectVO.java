package com.yjn.crowd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author yjn
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PortalProjectVO {
    private Integer projectId;
    private String projectName;
    private String headerPicturePath;
    private Integer money;
    private String deployDate;
    private Integer percentage;
    private Integer supporter;
}
