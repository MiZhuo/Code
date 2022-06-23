package site.mizhuo.orderserver.entity.DO;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName OrderDO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 15:20
 * @Version 1.0
 **/
@Entity
@Table(name = "tb_order", schema = "spike", catalog = "")
public class OrderDO {
    private Long orderId;
    private Long totalFee;
    private Long actualFee;
    private String promotionIds;
    private Boolean paymentType;
    private Long postFee;
    private Long userId;
    private Integer invoiceType;
    private Integer sourceType;
    private Boolean status;
    private Timestamp createTime;
    private Timestamp payTime;
    private Timestamp consignTime;
    private Timestamp endTime;
    private Timestamp closeTime;
    private Timestamp commentTime;
    private Timestamp updateTime;
    private OrderDetailDO orderDetailDO;

    @Id
    @Column(name = "order_id")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "total_fee")
    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    @Basic
    @Column(name = "actual_fee")
    public Long getActualFee() {
        return actualFee;
    }

    public void setActualFee(Long actualFee) {
        this.actualFee = actualFee;
    }

    @Basic
    @Column(name = "promotion_ids")
    public String getPromotionIds() {
        return promotionIds;
    }

    public void setPromotionIds(String promotionIds) {
        this.promotionIds = promotionIds;
    }

    @Basic
    @Column(name = "payment_type")
    public Boolean getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Boolean paymentType) {
        this.paymentType = paymentType;
    }

    @Basic
    @Column(name = "post_fee")
    public Long getPostFee() {
        return postFee;
    }

    public void setPostFee(Long postFee) {
        this.postFee = postFee;
    }

    @Basic
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "invoice_type")
    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    @Basic
    @Column(name = "source_type")
    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    @Basic
    @Column(name = "status")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "pay_time")
    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "consign_time")
    public Timestamp getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Timestamp consignTime) {
        this.consignTime = consignTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "close_time")
    public Timestamp getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Timestamp closeTime) {
        this.closeTime = closeTime;
    }

    @Basic
    @Column(name = "comment_time")
    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @OneToOne
    @JoinColumn(name = "order_id",insertable = false,updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    public OrderDetailDO getOrderDetailDO() {
        return orderDetailDO;
    }

    public void setOrderDetailDO(OrderDetailDO orderDetailDO) {
        this.orderDetailDO = orderDetailDO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderDO orderDO = (OrderDO) o;
        return Objects.equals(orderId, orderDO.orderId) && Objects.equals(totalFee, orderDO.totalFee) && Objects.equals(actualFee, orderDO.actualFee) && Objects.equals(promotionIds, orderDO.promotionIds) && Objects.equals(paymentType, orderDO.paymentType) && Objects.equals(postFee, orderDO.postFee) && Objects.equals(userId, orderDO.userId) && Objects.equals(invoiceType, orderDO.invoiceType) && Objects.equals(sourceType, orderDO.sourceType) && Objects.equals(status, orderDO.status) && Objects.equals(createTime, orderDO.createTime) && Objects.equals(payTime, orderDO.payTime) && Objects.equals(consignTime, orderDO.consignTime) && Objects.equals(endTime, orderDO.endTime) && Objects.equals(closeTime, orderDO.closeTime) && Objects.equals(commentTime, orderDO.commentTime) && Objects.equals(updateTime, orderDO.updateTime) && Objects.equals(orderDetailDO, orderDO.orderDetailDO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, totalFee, actualFee, promotionIds, paymentType, postFee, userId, invoiceType, sourceType, status, createTime, payTime, consignTime, endTime, closeTime, commentTime, updateTime, orderDetailDO);
    }
}
