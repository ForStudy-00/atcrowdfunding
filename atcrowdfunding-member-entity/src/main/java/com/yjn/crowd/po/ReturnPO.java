package com.yjn.crowd.po;

import java.io.Serializable;
import lombok.Data;

/**
 * t_return
 * @author 
 */
@Data
public class ReturnPO implements Serializable {
    private Integer id;

    private Integer projectid;

    /**
     * 0 - 实物回报， 1 虚拟物品回报
     */
    private Integer type;

    /**
     * 支持金额
     */
    private Integer supportmoney;

    /**
     * 回报内容
     */
    private String content;

    /**
     * 回报产品限额， “0” 为不限回报数量
     */
    private Integer count;

    /**
     * 是否设置单笔限购
     */
    private Integer signalpurchase;

    /**
     * 具体限购数量
     */
    private Integer purchase;

    /**
     * 运费， “0” 为包邮
     */
    private Integer freight;

    /**
     * 0 - 不开发票， 1 - 开发票
     */
    private Integer invoice;

    /**
     * 项目结束后多少天向支持者发送回报
     */
    private Integer returndate;

    /**
     * 说明图片路径
     */
    private String describPicPath;

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
        ReturnPO other = (ReturnPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSupportmoney() == null ? other.getSupportmoney() == null : this.getSupportmoney().equals(other.getSupportmoney()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getSignalpurchase() == null ? other.getSignalpurchase() == null : this.getSignalpurchase().equals(other.getSignalpurchase()))
            && (this.getPurchase() == null ? other.getPurchase() == null : this.getPurchase().equals(other.getPurchase()))
            && (this.getFreight() == null ? other.getFreight() == null : this.getFreight().equals(other.getFreight()))
            && (this.getInvoice() == null ? other.getInvoice() == null : this.getInvoice().equals(other.getInvoice()))
            && (this.getReturndate() == null ? other.getReturndate() == null : this.getReturndate().equals(other.getReturndate()))
            && (this.getDescribPicPath() == null ? other.getDescribPicPath() == null : this.getDescribPicPath().equals(other.getDescribPicPath()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSupportmoney() == null) ? 0 : getSupportmoney().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getSignalpurchase() == null) ? 0 : getSignalpurchase().hashCode());
        result = prime * result + ((getPurchase() == null) ? 0 : getPurchase().hashCode());
        result = prime * result + ((getFreight() == null) ? 0 : getFreight().hashCode());
        result = prime * result + ((getInvoice() == null) ? 0 : getInvoice().hashCode());
        result = prime * result + ((getReturndate() == null) ? 0 : getReturndate().hashCode());
        result = prime * result + ((getDescribPicPath() == null) ? 0 : getDescribPicPath().hashCode());
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
        sb.append(", type=").append(type);
        sb.append(", supportmoney=").append(supportmoney);
        sb.append(", content=").append(content);
        sb.append(", count=").append(count);
        sb.append(", signalpurchase=").append(signalpurchase);
        sb.append(", purchase=").append(purchase);
        sb.append(", freight=").append(freight);
        sb.append(", invoice=").append(invoice);
        sb.append(", returndate=").append(returndate);
        sb.append(", describPicPath=").append(describPicPath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}