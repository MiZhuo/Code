package site.mizhuo.userserver.entity.VO;

/**
 * @ClassName UserVO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-09 11:47
 * @Version 1.0
 **/
public class UserVO {

    private String username;
    private String password;
    private String phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
