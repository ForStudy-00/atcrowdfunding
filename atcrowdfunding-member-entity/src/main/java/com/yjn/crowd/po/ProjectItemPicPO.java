package com.yjn.crowd.po;

import java.io.Serializable;
import lombok.Data;

/**
 * t_project_item_pic
 * @author 
 */
@Data
public class ProjectItemPicPO implements Serializable {
    private Integer id;

    private Integer projectid;

    private String itemPicPath;

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
        ProjectItemPicPO other = (ProjectItemPicPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
            && (this.getItemPicPath() == null ? other.getItemPicPath() == null : this.getItemPicPath().equals(other.getItemPicPath()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        result = prime * result + ((getItemPicPath() == null) ? 0 : getItemPicPath().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectid=").append(projectid);
        sb.append(", itemPicPath=").append(itemPicPath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}