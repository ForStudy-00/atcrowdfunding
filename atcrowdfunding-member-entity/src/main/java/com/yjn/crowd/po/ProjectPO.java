package com.yjn.crowd.po;

import java.io.Serializable;
import lombok.Data;

/**
 * t_project
 * @author 
 */
@Data
public class ProjectPO implements Serializable {
    private Integer id;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目描述
     */
    private String projectDescription;

    /**
     * 筹集金额
     */
    private Long money;

    /**
     * 筹集天数
     */
    private Integer day;

    /**
     * 0-即将开始， 1-众筹中， 2-众筹成功， 3-众筹失败

     */
    private Integer status;

    /**
     * 项目发起时间
     */
    private String deploydate;

    /**
     * 已筹集到的金额
     */
    private Long supportmoney;

    /**
     * 支持人数
     */
    private Integer supporter;

    /**
     * 百分比完成度
     */
    private Integer completion;

    /**
     * 发起人的会员 id
     */
    private Integer memberid;

    /**
     * 项目创建时间
     */
    private String createdate;

    /**
     * 关注人数
     */
    private Integer follower;

    /**
     * 头图路径
     */
    private String headerPicturePath;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ProjectPO other = (ProjectPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectDescription() == null ? other.getProjectDescription() == null : this.getProjectDescription().equals(other.getProjectDescription()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getDay() == null ? other.getDay() == null : this.getDay().equals(other.getDay()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDeploydate() == null ? other.getDeploydate() == null : this.getDeploydate().equals(other.getDeploydate()))
            && (this.getSupportmoney() == null ? other.getSupportmoney() == null : this.getSupportmoney().equals(other.getSupportmoney()))
            && (this.getSupporter() == null ? other.getSupporter() == null : this.getSupporter().equals(other.getSupporter()))
            && (this.getCompletion() == null ? other.getCompletion() == null : this.getCompletion().equals(other.getCompletion()))
            && (this.getMemberid() == null ? other.getMemberid() == null : this.getMemberid().equals(other.getMemberid()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getFollower() == null ? other.getFollower() == null : this.getFollower().equals(other.getFollower()))
            && (this.getHeaderPicturePath() == null ? other.getHeaderPicturePath() == null : this.getHeaderPicturePath().equals(other.getHeaderPicturePath()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectDescription() == null) ? 0 : getProjectDescription().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getDay() == null) ? 0 : getDay().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDeploydate() == null) ? 0 : getDeploydate().hashCode());
        result = prime * result + ((getSupportmoney() == null) ? 0 : getSupportmoney().hashCode());
        result = prime * result + ((getSupporter() == null) ? 0 : getSupporter().hashCode());
        result = prime * result + ((getCompletion() == null) ? 0 : getCompletion().hashCode());
        result = prime * result + ((getMemberid() == null) ? 0 : getMemberid().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getFollower() == null) ? 0 : getFollower().hashCode());
        result = prime * result + ((getHeaderPicturePath() == null) ? 0 : getHeaderPicturePath().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectDescription=").append(projectDescription);
        sb.append(", money=").append(money);
        sb.append(", day=").append(day);
        sb.append(", status=").append(status);
        sb.append(", deploydate=").append(deploydate);
        sb.append(", supportmoney=").append(supportmoney);
        sb.append(", supporter=").append(supporter);
        sb.append(", completion=").append(completion);
        sb.append(", memberid=").append(memberid);
        sb.append(", createdate=").append(createdate);
        sb.append(", follower=").append(follower);
        sb.append(", headerPicturePath=").append(headerPicturePath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}