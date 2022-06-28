package site.mizhuo.springframework.support;

import site.mizhuo.springframework.config.BeanDefinition;

/**
 * @InterfaceName BeanDefinitionRegistry
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-24 15:01
 * @Version 1.0
 **/
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
