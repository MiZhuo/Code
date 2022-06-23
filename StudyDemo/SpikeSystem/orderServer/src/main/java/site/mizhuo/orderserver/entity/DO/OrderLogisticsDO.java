package site.mizhuo.orderserver.entity.DO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName OrderLogisticsDO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 15:20
 * @Version 1.0
 **/
@Entity
@Table(name = "tb_order_logistics", schema = "spike", catalog = "")
public class OrderLogisticsDO {
    private Long orderId;
    private String logisticsNumber;
    private String logisticsCompany;
    private String addressee;
    private String phone;
    private String province;
    private String city;
    private String district;
    private String street;
    private Integer postcode;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "order_id")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "logistics_number")
    public String getLogisticsNumber() {
        return logisticsNumber;
    }

    public void setLogisticsNumber(String logisticsNumber) {
        this.logisticsNumber = logisticsNumber;
    }

    @Basic
    @Column(name = "logistics_company")
    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    @Basic
    @Column(name = "addressee")
    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "postcode")
    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
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
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLogisticsDO that = (OrderLogisticsDO) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(logisticsNumber, that.logisticsNumber) && Objects.equals(logisticsCompany, that.logisticsCompany) && Objects.equals(addressee, that.addressee) && Objects.equals(phone, that.phone) && Objects.equals(province, that.province) && Objects.equals(city, that.city) && Objects.equals(district, that.district) && Objects.equals(street, that.street) && Objects.equals(postcode, that.postcode) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, logisticsNumber, logisticsCompany, addressee, phone, province, city, district, street, postcode, createTime, updateTime);
    }
}
