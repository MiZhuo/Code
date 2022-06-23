package site.mizhuo.springframework;

import org.junit.Test;
import site.mizhuo.springframework.config.BeanDefinition;
import site.mizhuo.springframework.config.BeanReference;
import site.mizhuo.springframework.dao.UserDao;
import site.mizhuo.springframework.service.UserService;
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
        factory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        factory.registerBeanDefinition("userService",new BeanDefinition(UserService.class,propertyValues));
        // 第一次获取bean
        UserService userService = (UserService) factory.getBean("userService","MiZhuo");
        System.out.println(userService);
        // 使用bean
        System.out.println(userService.queryUserInfo("003"));
    }
}
