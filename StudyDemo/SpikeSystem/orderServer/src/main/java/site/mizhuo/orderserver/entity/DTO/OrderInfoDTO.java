package site.mizhuo.orderserver.entity.DTO;

import java.sql.Timestamp;

/**
 * @ClassName OrderInfoDTO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-10 11:18
 * @Version 1.0
 **/
public class OrderInfoDTO {

    private Long orderId;
    private Long totalFee;
    private Long actualFee;
    private Boolean paymentType;
    private Long postFee;
    private Long userId;
    private Boolean status;
    private Timestamp createTime;
    private Integer num;
    private String title;
    private String ownSpec;
    private Long price;
    private String images;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public Long getActualFee() {
        return actualFee;
    }

    public void setActualFee(Long actualFee) {
        this.actualFee = actualFee;
    }

    public Boolean getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Boolean paymentType) {
        this.paymentType = paymentType;
    }

    public Long getPostFee() {
        return postFee;
    }

    public void setPostFee(Long postFee) {
        this.postFee = postFee;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnSpec() {
        return ownSpec;
    }

    public void setOwnSpec(String ownSpec) {
        this.ownSpec = ownSpec;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
