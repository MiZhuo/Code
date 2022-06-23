package site.mizhuo.springframework;

import org.junit.Test;
import site.mizhuo.springframework.service.UserService_02;
import site.mizhuo.springframework.service.UserService_01;

/**
 * @ClassName Test
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-23 22:30
 * @Version 1.0
 **/
public class SpringTest {

    @Test
    public void test(){
        // 初始化工厂
        BeanFactory factory = new BeanFactory();
        // 注册bean
        factory.registerBeanDefinition("userService",new BeanDefinition(new UserService_01()));
        // 获取bean
        UserService_02 userService02 = (UserService_02) factory.getBean("userService");
        // 使用bean
        userService02.queryUserInfo();
    }
}
