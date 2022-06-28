package site.mizhuo.springframework;

import org.junit.Test;
import site.mizhuo.springframework.config.BeanDefinition;
import site.mizhuo.springframework.service.UserService_02;
import site.mizhuo.springframework.support.DefaultListableBeanFactory;

/**
 * @ClassName SpringTest
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-24 15:14
 * @Version 1.0
 **/
public class SpringTest {

    @Test
    public void test(){
        // 初始化工厂
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // 注册bean
        factory.registerBeanDefinition("userService",new BeanDefinition(UserService_02.class));
        // 第一次获取bean
        UserService_02 userService02 = (UserService_02) factory.getBean("userService","MiZhuo");
        System.out.println(userService02);
        // 使用bean
        userService02.queryUserInfo();
        // 第二次获取bean
        UserService_02 userService022 = (UserService_02) factory.getBean("userService","MiaoMiao");
        System.out.println(userService022);
        // 使用bean
        userService02.queryUserInfo();
    }
}
