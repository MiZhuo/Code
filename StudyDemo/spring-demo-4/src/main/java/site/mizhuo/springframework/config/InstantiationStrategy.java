package site.mizhuo.springframework.config;

import java.lang.reflect.Constructor;

/**
 * @InterfaceName InstantiationStrategy
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-25 22:30
 * @Version 1.0
 **/
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args);
}
