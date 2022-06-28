package site.mizhuo.springframework.service;

/**
 * @ClassName UserService
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-23 22:29
 * @Version 1.0
 **/
public class UserService_02 {

    private String name;

    public UserService_02(String name) {
        this.name = name;
    }

    public void queryUserInfo(){
        System.out.println("我就是" + this.name);
    }
}
