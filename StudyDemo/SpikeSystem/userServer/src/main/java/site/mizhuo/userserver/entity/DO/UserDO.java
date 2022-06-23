package site.mizhuo.userserver.entity.DO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName UserDO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 15:20
 * @Version 1.0
 **/
@Entity
@Table(name = "tb_user", schema = "spike", catalog = "")
public class UserDO {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDO userDO = (UserDO) o;
        return Objects.equals(id, userDO.id) && Objects.equals(username, userDO.username) && Objects.equals(password, userDO.password) && Objects.equals(phone, userDO.phone) && Objects.equals(createTime, userDO.createTime) && Objects.equals(updateTime, userDO.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, phone, createTime, updateTime);
    }
}
