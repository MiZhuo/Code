package site.mizhuo.userserver.entity.DTO;

import java.sql.Timestamp;

/**
 * @ClassName UserDTO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-09 11:47
 * @Version 1.0
 **/
public class UserDTO {
    private Long id;
    private String username;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
